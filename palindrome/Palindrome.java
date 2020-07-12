package deque.palindrome;

import deque.Deque;
import deque.LinkedDeque;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedDeque<Character> i = new LinkedDeque<>();
        for (int j = 0; j < word.length(); j++) {
            i.addLast(word.charAt(j));
        }
        return i;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> i = wordToDeque(word);
        if (i.size() == 0 | i.size() == 1) {
            return true;
        }
        char A = i.removeFirst();
        char B = i.removeLast();
        if (word.length() % 2 == 0) {
            //even palindromes
            while (i.size() != 0) {
                if (A != B) {
                    return false;
                }
                A = i.removeFirst();
                B = i.removeLast();
            }
        } else {
            if (A != B) {
                return false;
            }
            while (i.size() != 1) {
                if (A != B) {
                    return false;
                }
                A = i.removeFirst();
                B = i.removeLast();
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> i = wordToDeque(word);
        if (i.size() == 0 | i.size() == 1) {
            return true;
        }
        char A = i.removeFirst();
        char B = i.removeLast();
        if (word.length() % 2 == 0) {
            //even palindromes
            while (i.size() != 0) {
                if (!cc.equalChars(A, B)) {
                    return false;
                }
                A = i.removeFirst();
                B = i.removeLast();
            }
        } else {
            if (!cc.equalChars(A, B)) {
                return false;
            }
            while (i.size() != 1) {
                if (!cc.equalChars(A, B)) {
                    return false;
                }
                A = i.removeFirst();
                B = i.removeLast();
            }
        }
        return true;
    }
}
