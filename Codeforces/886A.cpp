#include <iostream>     // std::cout
#include <algorithm>    // std::next_permutation, std::sort

int main () {


  int qtynum = 6;

  int num[qtynum];

  for (int i = 0; i < qtynum; i++) {
     std::cin >> num[i];
  }

  std::sort(num, num+qtynum);

  do {
    if((num[0] + num[1] + num[2]) == (num[3] + num[4] + num[5])) {
      std::cout << "YES" << '\n';
      return 0;
    }
    // std::cout << num[0] << ' '<< num[1] << ' '<< num[2] << ' '<< num[3] << ' '<< num[4] << ' '<< num[5] << '\n';
  } while ( std::next_permutation(num,num+6) );

  std::cout << "NO" << '\n';
  return 0;
}
