package top.tinn.Over200.Problem_648;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {
    private Trie root;
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");
        root = new Trie();
        getTree(dict);
        for (int i = 0; i < words.length; i++){
            words[i] = getRoot(words[i], root);
        }
        return "".join(" ", words);
    }

    private String getRoot(String word, Trie root) {
        for (char c : word.toCharArray()){
            if (root.word != null){
                return root.word;
            }
            if (root.children[c - 'a'] == null){
                return word;
            }
            root = root.children[c - 'a'];
        }
        return word;
    }

    private void getTree(List<String> dict) {
        for (String str : dict){
            Trie node = root;
            boolean flag = true;
            for (char c : str.toCharArray()){
                if (node.word != null){
                    flag = false;
                    break;
                }
                if (node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            if (flag){
                node.word = str;
                node.children = new Trie[26];
                //System.out.println(str);
            }
        }
    }

    static class Trie{
        Trie[] children;
        String word;
        Trie(){
            children = new Trie[26];
        }
    }

    @Test
    public void test(){
        List<String> dict = new ArrayList<>(Arrays.asList("e","k","c","harqp","h","gsafc","vn","lqp","soy","mr","x","iitgm","sb","oo","spj","gwmly","iu","z","f","ha","vds","v","vpx","fir","t","xo","apifm","tlznm","kkv","nxyud","j","qp","omn","zoxp","mutu","i","nxth","dwuer","sadl","pv","w","mding","mubem","xsmwc","vl","farov","twfmq","ljhmr","q","bbzs","kd","kwc","a","buq","sm","yi","nypa","xwz","si","amqx","iy","eb","qvgt","twy","rf","dc","utt","mxjfu","hm","trz","lzh","lref","qbx","fmemr","gil","go","qggh","uud","trnhf","gels","dfdq","qzkx","qxw"));
        String sentence = "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp";
        System.out.println(replaceWords(dict, sentence));
    }
}
