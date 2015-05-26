package org.netbeans.modules.autoupdate.silentupdate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.netbeans.api.autoupdate.InstallSupport;
import org.netbeans.api.autoupdate.InstallSupport.Installer;
import org.netbeans.api.autoupdate.InstallSupport.Validator;
import org.netbeans.api.autoupdate.OperationContainer;
import org.netbeans.api.autoupdate.OperationContainer.OperationInfo;
import org.netbeans.api.autoupdate.OperationException;
import org.netbeans.api.autoupdate.OperationSupport;
import org.netbeans.api.autoupdate.OperationSupport.Restarter;
import org.netbeans.api.autoupdate.UpdateElement;
import org.netbeans.api.autoupdate.UpdateManager;
import org.netbeans.api.autoupdate.UpdateUnit;
import org.netbeans.api.autoupdate.UpdateUnitProvider;
import org.netbeans.api.autoupdate.UpdateUnitProviderFactory;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;

/**
 *
 */
public final class UpdateHandler {
    private static HashSet<String> modulesToLoad = new HashSet();
    public static final String SILENT_UC_CODE_NAME = "org_netbeans_modules_autoupdate_silentupdate_update_center"; // NOI18N

    
    public static void LoadUnload(String s){
        modulesToLoad.clear();

        String[] command = s.split(" ");

        if(command.length == 2){
            String module = "dk.sdu.group3.semprojekt." +command[1].trim();

            if(command[0].toLowerCase().equals("load")){
                modulesToLoad.add(module);
            }
            else if(command[0].toLowerCase().equals("unload")){            
                doDisable(module);
            }
            else{
                System.out.println("Unknow command");
            }
        }
        else{
            System.out.println("Unknow command");
        }
    }

    public static boolean timeToCheck() {
        // every startup
        return true;
    }

    public static class UpdateHandlerException extends Exception {

        public UpdateHandlerException(String msg) {
            super(msg);
        }

        public UpdateHandlerException(String msg, Throwable th) {
            super(msg, th);
        }
    }

    public static void checkAndHandleUpdates() {
        // refresh silent update center first
        refreshSilentUpdateProvider();

        Collection<UpdateElement> updates = findUpdates();
        Collection<UpdateElement> available = Collections.emptySet();
        if (installNewModules()) {
            available = findNewModules();
        }
        if (updates.isEmpty() && available.isEmpty()) {
            // none for install
            OutputLogger.log("None for install");
            return;
        }

        // create a container for install
        OperationContainer<InstallSupport> containerForInstall = feedContainer(available, false);
        if (containerForInstall != null) {
            try {
                handleInstall(containerForInstall);
                OutputLogger.log("Install new modules done.");
            } catch (UpdateHandlerException ex) {
                OutputLogger.log(ex.getLocalizedMessage(), ex.getCause());
                return;
            }
        }

        // create a container for update
        OperationContainer<InstallSupport> containerForUpdate = feedContainer(updates, true);
        if (containerForUpdate != null) {
            try {
                handleInstall(containerForUpdate);
                OutputLogger.log("Update done.");
            } catch (UpdateHandlerException ex) {
                OutputLogger.log(ex.getLocalizedMessage(), ex.getCause());
                return;
            }
        }

    }

    public static boolean isLicenseApproved(String license) {
        // place your code there
        return true;
    }

    // package private methods
    static Collection<UpdateElement> findUpdates() {
        // check updates
        Collection<UpdateElement> elements4update = new HashSet<UpdateElement>();
        List<UpdateUnit> updateUnits = UpdateManager.getDefault().getUpdateUnits();
        for (UpdateUnit unit : updateUnits) {
            if (unit.getInstalled() != null) { // means the plugin already installed
                if (!unit.getAvailableUpdates().isEmpty()) { // has updates
                    elements4update.add(unit.getAvailableUpdates().get(0)); // add plugin with highest version
                }
            }
        }
        return elements4update;
    }

    static void handleInstall(OperationContainer<InstallSupport> container) throws UpdateHandlerException {
        // check licenses
        if (!allLicensesApproved(container)) {
            // have a problem => cannot continue
            throw new UpdateHandlerException("Cannot continue because license approval is missing for some updates.");
        }

        // download
        InstallSupport support = container.getSupport();
        Validator v = null;
        try {
            v = doDownload(support);
        } catch (OperationException ex) {
            // caught a exception
            throw new UpdateHandlerException("A problem caught while downloading, cause: ", ex);
        }
        if (v == null) {
            // have a problem => cannot continue
            throw new UpdateHandlerException("Missing Update Validator => cannot continue.");
        }

        // verify
        Installer i = null;
        try {
            i = doVerify(support, v);
        } catch (OperationException ex) {
            // caught a exception
            throw new UpdateHandlerException("A problem caught while verification of updates, cause: ", ex);
        }
        if (i == null) {
            // have a problem => cannot continue
            throw new UpdateHandlerException("Missing Update Installer => cannot continue.");
        }

        // install
        Restarter r = null;
        try {
            r = doInstall(support, i);
        } catch (OperationException ex) {
            // caught a exception
            throw new UpdateHandlerException("A problem caught while installation of updates, cause: ", ex);
        }

        // restart later
        support.doRestartLater(r);
        return;
    }

    static Collection<UpdateElement> findNewModules() {
        // check updates
        Collection<UpdateElement> elements4install = new HashSet<UpdateElement>();
        List<UpdateUnit> updateUnits = UpdateManager.getDefault().getUpdateUnits();
        for (UpdateUnit unit : updateUnits) {
            if (unit.getInstalled() == null) { // means the plugin is not installed yet
                if (!unit.getAvailableUpdates().isEmpty()) { // is available
                    if(modulesToLoad.contains(unit.getCodeName()))
                        elements4install.add(unit.getAvailableUpdates().get(0)); // add plugin with highest version
                }
            }
        }
        return elements4install;
    }

    static void refreshSilentUpdateProvider() {
        UpdateUnitProvider silentUpdateProvider = getSilentUpdateProvider();
        if (silentUpdateProvider == null) {
            // have a problem => cannot continue
            OutputLogger.log("Missing Silent Update Provider => cannot continue.");
            return;
        }
        try {
            silentUpdateProvider.refresh(null, true);
        } catch (IOException ex) {
            // caught a exception
            OutputLogger.log("A problem caught while refreshing Update Centers, cause: ", ex);
        }
    }

    static UpdateUnitProvider getSilentUpdateProvider() {
        List<UpdateUnitProvider> providers = UpdateUnitProviderFactory.getDefault().getUpdateUnitProviders(true);
        for (UpdateUnitProvider p : providers) {
            if (SILENT_UC_CODE_NAME.equals(p.getName())) {
                try {
                    p.refresh(null, true);
                } catch (IOException ex) {
                    // caught a exception
                    OutputLogger.log("A problem caught while refreshing Update Centers, cause: ", ex);
                }
                return p;
            }
        }
        return null;
    }

    static OperationContainer<InstallSupport> feedContainer(Collection<UpdateElement> updates, boolean update) {
        if (updates == null || updates.isEmpty()) {
            return null;
        }
        // create a container for update
        OperationContainer<InstallSupport> container;
        if (update) {
            container = OperationContainer.createForUpdate();
        } else {
            container = OperationContainer.createForInstall();
        }

        // loop all updates and add to container for update
        for (UpdateElement ue : updates) {
            if (container.canBeAdded(ue.getUpdateUnit(), ue)) {
                OutputLogger.log("Update found: " + ue);
                OperationInfo<InstallSupport> operationInfo = container.add(ue);
                if (operationInfo == null) {
                    continue;
                }
                container.add(operationInfo.getRequiredElements());
                if (!operationInfo.getBrokenDependencies().isEmpty()) {
                    // have a problem => cannot continue
                    OutputLogger.log("There are broken dependencies => cannot continue, broken deps: " + operationInfo.getBrokenDependencies());
                    return null;
                }
            }
        }
        return container;
    }

    static boolean allLicensesApproved(OperationContainer<InstallSupport> container) {
        if (!container.listInvalid().isEmpty()) {
            return false;
        }
        for (OperationInfo<InstallSupport> info : container.listAll()) {
            String license = info.getUpdateElement().getLicence();
            if (!isLicenseApproved(license)) {
                return false;
            }
        }
        return true;
    }

    static Validator doDownload(InstallSupport support) throws OperationException {
        return support.doDownload(null, true);
    }

    static Installer doVerify(InstallSupport support, Validator validator) throws OperationException {

        Installer installer = support.doValidate(validator, null); // validates all plugins are correctly downloaded
        // XXX: use there methods to make sure updates are signed and trusted
        // installSupport.isSigned(installer, <an update element>);
        // installSupport.isTrusted(installer, <an update element>);
        return installer;
    }

    static Restarter doInstall(InstallSupport support, Installer installer) throws OperationException {
        return support.doInstall(installer, null);
    }

    private static boolean installNewModules() {
        String s = NbBundle.getBundle("org.netbeans.modules.autoupdate.silentupdate.resources.Bundle").getString("UpdateHandler.NewModules");
        return Boolean.parseBoolean(s);
    }
    
    private static void doDisable (String codeNames) { // codeName contains code name of modules for disable
        OperationContainer<OperationSupport> oc = OperationContainer.createForDirectUninstall();

        for(UpdateUnit unit : UpdateManager.getDefault().getUpdateUnits(UpdateManager.TYPE.MODULE)) {
            if (unit.getInstalled() != null) { // filter all installed modules
                UpdateElement el = unit.getInstalled();
                if (el.isEnabled()) { // filter all enabled modules
                    if (codeNames.equals(el.getCodeName())) { // filter given module in the parameter
                        if(oc.canBeAdded (unit, el)){ // check if module can be disabled
                            OperationInfo operationInfo = oc.add(el);
                            if(operationInfo != null){ // check that it's not already planned to be disabled
                                oc.add(operationInfo.getRequiredElements()); // add all of them between modules for disable
                            }
                        }
                    }
                }
            }
        }

        if(!oc.listAll().isEmpty()){ // check the container doesn't contain any invalid element
            try {
            Restarter restarter = oc.getSupport().doOperation(null); // get operation support for complete the disable operation
            } catch (OperationException ex) {
                Exceptions.printStackTrace (ex);
            }
        }
    }
}
