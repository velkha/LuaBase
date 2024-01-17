package lua.base.consola.luabase.enums.commands;

public interface ICommandEnum {
    String getKey();
    String getDescription();
    ICommandEnum fromKey(String key);
}
