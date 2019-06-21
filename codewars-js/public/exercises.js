// accum (7 kyu)
/*
accum("abcd") -> "A-Bb-Ccc-Dddd"
accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
accum("cwAt") -> "C-Ww-Aaa-Tttt"
 */

// Square Every Digit (7 kyu)
/*
square every digit of a number.

For example, if we run 9119 through
the function, 811181 will come out,
because 92 is 81 and 12 is 1.

squareDigits(9119);
console.log(typeof squareDigits(9119) === "number");
*/

// Build Tower (6 kyu)
/*
Build Tower by the following given argument:
number of floors (integer and always greater than 0).

Tower block is represented as *
for example, a tower of 3 floors looks like below
[
  '  *  ',
  ' *** ',
  '*****'
]
console.log(towerBuilder(6));
*/

// Exes and Ohs (7 kyu)
/*
Check to see if a string has the same amount of
'x's and 'o's. The method must return a boolean
and be case insensitive. The string can contain
any char.

Examples input/output:

XO("ooxx") => true
XO("xooxx") => false
XO("ooxXm") => true
XO("zpzpzpp") => true // when no 'x' and 'o' is present
                         should return true
XO("zzoo") => false

console.log(XO("zzoo"));
*/

// Array.diff (6 kyu)
/*
Your goal in this kata is to implement
a difference function, which subtracts
one list from another and returns the result.

It should remove all values from list a,
which are present in list b.

array_diff([1,2],[1]) == [2]

If a value is present in b, all of its
occurrences must be removed from the other:

array_diff([1,2,2,2,3],[2]) == [1,3]

console.log(array_diff([1,2,2,2,3],[2]));
*/

// Isograms (7 kyu)
/*
An isogram is a word that has no repeating
letters, consecutive or non-consecutive.
Implement a function that determines whether
a string that contains only letters is an
isogram. Assume the empty string is an isogram.
Ignore letter case.

isIsogram( "Dermatoglyphics" ) == true
isIsogram( "aba" ) == false
isIsogram( "moOse" ) == false // -- ignore letter case

console.log(isIsogram("moOse"));
*/

// Detect Pangram (6 kyu)
/*
A pangram is a sentence that contains every
single letter of the alphabet at least once.
For example, the sentence
"The quick brown fox jumps over the lazy dog"
is a pangram, because it uses the letters A-Z
at least once (case is irrelevant).

Given a string, detect whether or not it is a
pangram. Return True if it is, False if not.
Ignore numbers and punctuation.

console.log(isPangram("Cwm fjord bank glyphs vext quiz"));
*/

// Write Number in Expanded Form (6 kyu)
/*
You will be given a number and you will
need to return it as a string in Expanded
Form. For example:

expandedForm(12); // Should return '10 + 2'
expandedForm(42); // Should return '40 + 2'
expandedForm(70304); // Should return '70000 + 300 + 4'

NOTE: All numbers will be whole numbers greater than 0.
console.log(expandedForm(9000000));
*/

// Rot13 (5 kyu)
/*
ROT13 is a simple letter substitution
cipher that replaces a letter with the
letter 13 letters after it in the alphabet.
ROT13 is an example of the Caesar cipher.

Create a function that takes a string and
returns the string ciphered with Rot13.
If there are numbers or special characters
included in the string, they should be
returned as they are. Only letters from
the latin/english alphabet should be
shifted, like in the original Rot13
"implementation".

console.log(rot13("TEst"));
*/

function accum(s) {
  s = s.toLowerCase();
  let result = "";

  for (let i = 0; i < s.length; i++) {
    result += s[i].toUpperCase() + s[i].repeat(i);
    if (i === s.length - 1) {
      break;
    }
    result += "-";
  }

  return result;
}

function squareDigits(num){
  let numString = num.toString();
  let result = "";

  for (let i = 0; i < numString.length; i++) {
    result += numString[i] * numString[i];
  }
  return +result
}

function towerBuilder(nFloors) {
  let result = [];
  let nBlocks = 1;
  let bottom = -1;

  // find the bottom floor width, store it
  for (let i = 0; i < nFloors; i++) {
    bottom += 2;
  }

  for (let i = 0; i < nFloors; i++) {
    if (i === nFloors - 1) { // bottom floor, fill with blocks
      result[i] = '*'.repeat(nBlocks);
    } else { // not bottom, fill with spaces and blocks, decrement bottom
      result[i] = ' '.repeat(Math.floor(bottom/2)) +
        '*'.repeat(nBlocks) + ' '.repeat(Math.floor(bottom/2));
      nBlocks += 2;
      bottom -= 2;
    }
  }
  return result;
}

function XO(str) {
  str = str.toLowerCase();
  if (!str.includes('x') && !str.includes('o')) {
    return true;
  }

  let exOh = 0;
  for (let i = 0; i < str.length; i++) {
    if (str[i] === 'x') {
      exOh++;
    } else if (str[i] === 'o') {
      exOh--;
    }
  }
  return exOh === 0;
}

function array_diff(a, b) {
  for (let i = 0; i < a.length; i++) {
    if (b.includes(a[i])) {
      a.splice(i, 1);
      i--;
    }
  }
  return a;
}

function isIsogram(str){
  str = str.toLowerCase();

  for (let i = 0; i < str.length; i++) {
    if (str.slice(i + 1).includes(str[i])) {
      return false;
    }
  }
  return true;
}

function isPangram(string){
  string = string.toLowerCase();
  let alpha = 'abcdefghijklmnopqrstuvwxyz';

  for (let i = 0; i < alpha.length; i++) {
    if (!string.includes(alpha[i])) {
      return false;
    }
  }
  return true;
}

function expandedForm(num) {
  num = num.toString();
  let result = num[0] + '0'.repeat(num.length - 1);

  for (let i = 1; i < num.length; i++) {
    if (num[i] !== '0' && i === num.length - 1) {
      result += ' + ' + num[i];
    } else if (num[i] !== '0') {
      result += ' + ' + num[i] + '0'.repeat(num.length - i - 1);
    }
  }
  return result;
}

function rot13(message){
  let mLower = message.toLowerCase();
  let result = '';
  let alpha = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
  'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];
  let i = 0;

  while (i < message.length) {
    for (let j = 0; j < alpha.length; j++) {
      if (i >= message.length) {
        break;
      }
      if (!alpha.includes(mLower[i])) {
        result += message[i];
        i++;
      }
      // lots of redundant code here... will try to optimize later
      if (message[i] === alpha[j] && j + 13 > 25) {
        result += alpha[j - 13];
        i++;
      } else if (message[i] === alpha[j]) {
        result += alpha[j + 13];
        i++;
      } else if (mLower[i] === alpha[j] && j + 13 > 25) {
        result += alpha[j - 13].toUpperCase();
        i++;
      } else if (mLower[i] === alpha[j]) {
        result += alpha[j + 13].toUpperCase();
        i++;
      }
    }
  }
  return result;
}