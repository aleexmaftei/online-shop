package permits;

public final class Administrator {
    private static Administrator INSTANCE = null;
    private ActionType actionType;

    private Administrator() {
        actionType = ActionType.ADMIN_ACTION;
    }

    public static synchronized Administrator getAdminInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Administrator();
        }
        return INSTANCE;
    }

    public ActionType getActionType() {
        return actionType;
    }
}
