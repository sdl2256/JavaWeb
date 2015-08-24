package com.landsea.memu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDL on 2015/7/13.
 */
public class ConfigGroup {

    private String version;
    private String project;
    private List<ContextMenuConfig> menuConfigs = new ArrayList<ContextMenuConfig>();
    private List<MenuButtonConfig> buttonConfigs = new ArrayList<MenuButtonConfig>();

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public List<ContextMenuConfig> getMenuConfigs() {
        return menuConfigs;
    }

    public void setMenuConfigs(List<ContextMenuConfig> menuConfigs) {
        this.menuConfigs = menuConfigs;
    }

    public List<MenuButtonConfig> getButtonConfigs() {
        return buttonConfigs;
    }

    public void setButtonConfigs(List<MenuButtonConfig> buttonConfigs) {
        this.buttonConfigs = buttonConfigs;
    }

    @Override
    public String toString() {
        return "ConfigGroup{" +
                "version='" + version + '\'' +
                ", project='" + project + '\'' +
                ", menuConfigs=" + menuConfigs +
                ", buttonConfigs=" + buttonConfigs +
                '}';
    }
}
