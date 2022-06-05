
#include "merge_list.h"

namespace pu {

std::string MergeList::Merge1() {
  ListNode *new_list = Merge(GetLinkedList1(), GetLinkedList2());
  return ListToString(new_list);
}

std::string MergeList::MergeKLists() {
  std::vector<ListNode *> vector = {GetLinkedList1(), GetLinkedList2(),
                                    InitList3()};

  ListNode *new_list = DivideMerge(vector,0,vector.size()-1);

  return ListToString(new_list);
}

ListNode *MergeList::InitList3() {
  auto *list_node0 = new ListNode(1);
  auto *listNode1 = new ListNode(4);
  auto *listNode2 = new ListNode(5);
  auto *listNode3 = new ListNode(5);
  auto *listNode4 = new ListNode(8);
  auto *listNode5 = new ListNode(9);
  auto *listNode6 = new ListNode(99);
  auto *listNode7 = new ListNode(130);

  list_node0->next = listNode1;
  listNode1->next = listNode2;
  listNode2->next = listNode3;
  listNode3->next = listNode4;
  listNode4->next = listNode5;
  listNode5->next = listNode6;
  listNode6->next = listNode7;
  return list_node0;
}

ListNode *MergeList::Merge(ListNode *list1, ListNode *list2) {
  auto *new_list = new ListNode(-1);

  auto *temp = new_list;
  while (list1 && list2) {
    if (list1->val <= list2->val) {
      temp->next = list1;
      list1 = list1->next;
    } else {
      temp->next = list2;
      list2 = list2->next;
    }
    temp = temp->next;
  }
  if (!list1) {
    temp->next = list2;
  }
  if (!list2) {
    temp->next = list1;
  }
  return new_list->next;
}

ListNode *MergeList::DivideMerge(std::vector<ListNode *> list, int left,
                                 int right) {
  if (left == right) {
    return list.at(left);
  }
  if (left > right) {
    return nullptr;
  }
  int mid = left + ((right - left) >> 1);
  return Merge(DivideMerge(list, left, mid), DivideMerge(list, mid + 1, right));
}

} // namespace pu