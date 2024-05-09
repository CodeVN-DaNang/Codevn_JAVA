public class Block {
    private String blockName;
    private String subject;

    public Block() {
    }

    public Block(String blockName, String subject) {
        this.blockName = blockName;
        this.subject = subject;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Block [blockName=" + blockName + ", subject=" + subject + "]";
    }

}
