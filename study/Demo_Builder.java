class Phone {
    private final String phName;
    private final String os;
    private final int cores;
    private final boolean screenTouch;

    // Private constructor
    private Phone(Builder builder) 
    {
        this.phName = builder.phName;
        this.os = builder.os;
        this.cores = builder.cores;
        this.screenTouch = builder.screenTouch;
    }

    // Getters
    public String getPhName() { return phName; }
    public String getOs() { return os; }
    public int getCores() { return cores; }
    public boolean isScreenTouch() { return screenTouch; }

    // Static nested Builder class
    public static class Builder 
    {
        private String phName;
        private String os;
        private int cores;
        private boolean screenTouch;

        public Builder setPhName(String phName) 
        {
            this.phName = phName;
            return this;
        }
        public Builder setOs(String os) 
        {
            this.os = os;
            return this;
        }
        public Builder setCores(int cores) 
        {
            this.cores = cores;
            return this;
        }
        public Builder setScreenTouch(boolean screenTouch) 
        {
            this.screenTouch = screenTouch;
            return this;
        }
        public Phone build() 
        {
            return new Phone(this);
        }
    }

    // Static factory method for convenience (like HttpClient.newBuilder())
    public static Builder newBuilder() 
    {
        return new Builder();
    }
}

public class Demo_Builder 
{
    public static void main(String[] args) 
    {
        Phone phone = Phone.newBuilder()
            .setPhName("Samsung")
            .setOs("Android")
            .setCores(8)
            .setScreenTouch(true)
            .build();

        System.out.println(phone.getPhName());
    }
}
