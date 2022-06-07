#pragma once

#include "base_list.h"

namespace pu {

class AddList : public BaseList {
public:
  AddList() = default;
  ListNode *addTwoNumbers(ListNode *l1, ListNode *l2);
};

ListNode *AddList::addTwoNumbers(ListNode *l1, ListNode *l2) {
  ListNode *head = nullptr, *tail = nullptr;
  int carry = 0;
  while (l1 || l2) {
    int n1 = l1 ? l1->val: 0;
    int n2 = l2 ? l2->val: 0;
    int sum = n1 + n2 + carry;
    if (!head) {
      head = tail = new ListNode(sum % 10);
    } else {
      tail->next = new ListNode(sum % 10);
      tail = tail->next;
    }
    carry = sum / 10;
    if (l1) {
      l1 = l1->next;
    }
    if (l2) {
      l2 = l2->next;
    }
  }
  if (carry > 0) {
    tail->next = new ListNode(carry);
  }
  return head;
}

} // namespace pu
