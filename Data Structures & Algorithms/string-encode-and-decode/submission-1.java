class Solution {
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s : strs) {
      //  System.out.println(s);
      sb.append(s).append("/");
    }

    if (sb.charAt(sb.length() - 1) == '/')
      sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  public List<String> decode(String str) {
    System.out.println(str);
    List<String> l = new LinkedList<>();
    char[] sc = str.toCharArray();
    int i = 0;
    for (int j = 0; j < sc.length ; j++) {
      if (sc[j] == '/') {
        if (i == j)
          l.add("");
        else
          l.add(str.substring(i, j));
        i = j + 1;
      }
    }  

    if (sc.length == 0 || sc[sc.length - 1] == '/')
      l.add("");
    else if (i < sc.length) {
      l.add(str.substring(i, sc.length));
    }
    if (l.isEmpty())
      l.add("");
    return l;
  }
}
