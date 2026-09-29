class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String a = String.valueOf(c);
      List<String> l = map.getOrDefault(a, new LinkedList<String>());
      l.add(s);
      map.put(a, l);
    }
    List<List<String>> res = new LinkedList(map.values());
    return res;
  }
}
