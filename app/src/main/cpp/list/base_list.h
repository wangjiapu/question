#pragma once

#include "list_node.h"
#include <string>

namespace pu {

class BaseList {
public:
  BaseList() = default;
  ListNode* GetLinkedList1();
  ListNode* GetLinkedList2();
  ListNode* GetCycleList();
  ListNode* GetNumber1();
  ListNode* GetNumber2();
  std::string ListToString(ListNode *node);
};

} // namespace pu
