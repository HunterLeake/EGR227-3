public class AssassinNode {
    public String name;
    public String killer;
    public AssassinNode next;

    public AssassinNode(String name) {
        this.name = name;
        this.killer = null;
        this.next = null;
    }
}