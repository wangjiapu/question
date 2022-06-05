
#include "reverse_list.h"
#include "p_log.h"

namespace pu {

ReverseList::ReverseList() { head_ = GetLinkedList1(); }

std::string ReverseList::ReverseAll() {
  head_ = Reverse(head_);
  return ListToString(head_);
}

std::string ReverseList::ReverseBetween(int start, int end) {
  if (start > end || !head_) {
    return "错误的index!";
  }
  auto *temp = new ListNode(-1);

  temp->next = head_;
  ListNode *pre = temp;
  for (int i = 0; i < start - 1; ++i) {
    pre = pre->next;
  }
  ListNode *right = pre;
  for (int i = 0; i < end - start + 1; ++i) {
    right = right->next;
  }

  ListNode *sub_head = pre->next;
  ListNode *sub_end = right->next;

  pre->next = nullptr;
  right->next = nullptr;

  pre->next = Reverse(sub_head);
  sub_head->next = sub_end;
  return ListToString(temp->next);
}

ListNode *ReverseList::Reverse(ListNode *node) {
  ListNode *pre = nullptr;
  ListNode *cur = node;
  ListNode *nex = nullptr;
  while (cur) {
    nex = cur->next;
    cur->next = pre;
    pre = cur;
    cur = nex;
  }
  return pre;
}

} // namespace pu
