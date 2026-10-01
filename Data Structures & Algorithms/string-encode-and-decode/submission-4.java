class Solution {
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s : strs) {
      // Hint 3
      // We can use an encoding approach where we start with a number representing the length of the
      // string, followed by a separator character (let's use # for simplicity), and then the string
      // itself.
      // 0 <= strs[i].length < 200
      sb.append(String.format("%03d", s.length())).append("#").append(s);
    }
    return sb.toString();
  }

  public List<String> decode(String str) {
    List<String> l = new LinkedList<>();
    int i = 0;
    while (i < str.length()) {
      int n = Integer.parseInt(str.substring(i, i + 3));
      i += 4;
      l.add(str.substring(i, i + n));
      i += n;
    }


    return l;
  }
}
