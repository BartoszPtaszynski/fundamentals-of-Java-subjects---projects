public enum TravelStatus {
    COMPLETED,
    IN_PROGRESS,
    NOT_STARTED;
    public String getStatus()
    {
        return switch (this)
        {
            case COMPLETED -> "COMPLETED";
            case IN_PROGRESS -> "IN PROGRESS";
            case NOT_STARTED -> "NOT STARTED";
        };
    }
}
