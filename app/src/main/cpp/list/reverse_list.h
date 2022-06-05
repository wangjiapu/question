#pragma once

#include "base_list.h"
#include "list_node.h"
#include <string>

namespace pu {

class ReverseList : public BaseList {
public:
  ReverseList();

  std::string ReverseAll();
  std::string ReverseBetween(int start, int end);

private:
  ListNode *Reverse(ListNode *node);
  ListNode *head_ = NULL;
};

} // namespace pu
