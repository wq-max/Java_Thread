import java.util.Map;

public class BlackListServiceImpl {

    private static CopyOnWriteMap<String, Boolean> blackListMap =
            new CopyOnWriteMap<>();

    public static boolean isBlackList(String id) {
        return blackListMap.get(id) != null;
    }

    public static void addBlackList(String id) {
        blackListMap.put(id, true);
    }

    public static void addBlackList(Map<String, Boolean> ids) {
        blackListMap.putAll(ids);
    }
}
