package lua.base.consola.luabase.enums.commands;

public enum CommandOption implements ICommandEnum {
    OPTION_ONE("1", "Option One"),
    OPTION_TWO("2", "Option Two"),
    OPTION_THREE("3", "Option Three"),
    OPTION_FOUR("4", "Option Four"),
    EXIT("0", "Exit Application");

    private final String key;
    private final String description;

    CommandOption(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return key + ". " + description;
    }

    public ICommandEnum fromKey(String key) {
        for (CommandOption option : CommandOption.values()) {
            if (option.getKey().equals(key)) {
                return option;
            }
        }
        throw new IllegalArgumentException("No command option with key: " + key);
    }

}