package top.tinn.Contest_Single_192.Problem_03;

/**
 * @author Tintinnabu
 * @description
 * @data 2020/6/7
 */
public class BrowserHistory {
    class DNode {
        private String address;
        private DNode next;
        private DNode prev;

        public DNode(String address) {
            this.address = address;
        }
    }

    private DNode curNode;

    public BrowserHistory(String homepage) {
        curNode = new DNode(homepage);
    }

    public void visit(String url) {
        DNode newNode = new DNode(url);
        curNode.next = newNode;
        newNode.prev = curNode;
        curNode = newNode;
    }

    public String back(int steps) {
        while (steps > 0 && curNode.prev != null){
            curNode = curNode.prev;
            steps--;
        }
        return curNode.address;
    }

    public String forward(int steps) {
        while (steps > 0 && curNode.next != null){
            curNode = curNode.next;
            steps--;
        }
        return curNode.address;
    }
}
