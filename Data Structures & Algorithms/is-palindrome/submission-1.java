class Solution {
  char toDigitLowerCase(char c) {
    if (c >= 'A' && c <= 'Z') {
      return (char) ('a' + c - 'A');
    }
    return c;
  }
  boolean isAlphaNumeric(char c) {
    return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
  }
  public boolean isPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    char[] c = s.toCharArray();
    while (i<j &&!isAlphaNumeric(c[i])) i++;
    while (i<j &&!isAlphaNumeric(c[j])) j--;

    while (i < j) {
      if (toDigitLowerCase(c[i]) != toDigitLowerCase(c[j]))
        return false;
      do {
        i++;
      } while (!isAlphaNumeric(c[i]));
      do {
        j--;
      } while (!isAlphaNumeric(c[j]));
    }
    return true;
  }
}
