class Solution {
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s : strs) {
      sb.append(s);
      sb.append("/");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  public List<String> decode(String str) {
    System.out.println(str);
    List<String> l = new LinkedList<>();
    char[] sc = str.toCharArray();
    int i = 0;
    for (int j = 1; j < sc.length-1; j++) {
      if (sc[j] == '/' || j == sc.length - 1) {
        l.add(str.substring(i, j));
        i = j + 1;
      }
    }
    if (i < sc.length) {
      l.add(str.substring(i, sc.length));
    }
    if (l.isEmpty())l.add("");
    return l;
  }
}
