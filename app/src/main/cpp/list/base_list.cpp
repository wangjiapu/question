
#include "base_list.h"

namespace pu {

std::string BaseList::ListToString(ListNode *head) {
  std::string result;
  ListNode *node = head;
  while (node != nullptr) {
    result.append(std::to_string(node->val) + ",");
    node = node->next;
  }
  return result;
}

ListNode *BaseList::GetLinkedList1() {
  auto *list_node0 = new ListNode(0);
  auto *listNode1 = new ListNode(1);
  auto *listNode2 = new ListNode(3);
  auto *listNode3 = new ListNode(5);
  auto *listNode4 = new ListNode(7);
  auto *listNode5 = new ListNode(9);
  auto *listNode6 = new ListNode(11);
  auto *listNode7 = new ListNode(13);

  list_node0->next = listNode1;
  listNode1->next = listNode2;
  listNode2->next = listNode3;
  listNode3->next = listNode4;
  listNode4->next = listNode5;
  listNode5->next = listNode6;
  listNode6->next = listNode7;
  return list_node0;
}

ListNode *BaseList::GetLinkedList2() {
  auto *list_node0 = new ListNode(2);
  auto *listNode1 = new ListNode(4);
  auto *listNode2 = new ListNode(6);
  auto *listNode3 = new ListNode(8);
  auto *listNode4 = new ListNode(10);
  auto *listNode5 = new ListNode(16);
  auto *listNode6 = new ListNode(18);
  auto *listNode7 = new ListNode(40);

  list_node0->next = listNode1;
  listNode1->next = listNode2;
  listNode2->next = listNode3;
  listNode3->next = listNode4;
  listNode4->next = listNode5;
  listNode5->next = listNode6;
  listNode6->next = listNode7;
  return list_node0;
}

ListNode *BaseList::GetCycleList() {
  auto *list_node0 = new ListNode(2);
  auto *listNode1 = new ListNode(4);
  auto *listNode2 = new ListNode(6);
  auto *listNode3 = new ListNode(8);
  auto *listNode4 = new ListNode(10);

  list_node0->next = listNode1;
  listNode1->next = listNode2;
  listNode2->next = listNode3;
  listNode3->next = listNode4;
  listNode4->next = listNode2;
  return list_node0;
}

} // namespace pu