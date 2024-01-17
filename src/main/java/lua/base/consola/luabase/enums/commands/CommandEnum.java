package lua.base.consola.luabase.enums.commands;

public enum CommandEnum {;
    private final String key;
    private final String description;

    CommandEnum(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public static CommandOption fromKey(String key) {
        for (CommandOption option : CommandOption.values()) {
            if (option.getKey().equals(key)) {
                return option;
            }
        }
        throw new IllegalArgumentException("No command option with key: " + key);
    }

    @Override
    public String toString() {
        return key + ". " + description;
    }
}
