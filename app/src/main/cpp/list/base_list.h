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


protected:
  std::string ListToString(ListNode *node);
};

} // namespace pu
