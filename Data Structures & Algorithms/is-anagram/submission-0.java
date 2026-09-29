class Solution {
  public boolean isAnagram(String s, String t) {
    int[] abc = new int[26];

    if (s.length() != t.length())
      return false;
    char[] sc = s.toCharArray();
    char[] tc = t.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      abc[sc[i]-'a']++;
      abc[tc[i]-'a']--;
    }
    for (int n : abc) {
      if (n != 0)
        return false;
    }
    return true;
  }
}
