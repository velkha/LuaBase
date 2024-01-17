package lua.base.consola.luabase.util;

import lua.base.consola.luabase.enums.commands.ICommandEnum;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EnumUtil {
    public static <E extends Enum<E> & ICommandEnum> Set<String> getKeys(Class<E> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .map(ICommandEnum::getKey)
                .collect(Collectors.toSet());
    }
    public static <E extends Enum<E> & ICommandEnum> E fromKey(Class<E> enumClass, String key) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(enumConstant -> enumConstant.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Key no encontrada: " + key));
    }
}
