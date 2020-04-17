package file_management.write;

public final class WriteFile {
    private static WriteFile WRITE_INSTANCE = null;

    private WriteFile() {
    }

    public static synchronized WriteFile getWriteFileInstance() {
        if (WRITE_INSTANCE == null) {
            WRITE_INSTANCE = new WriteFile();
        }
        return WRITE_INSTANCE;
    }

}
