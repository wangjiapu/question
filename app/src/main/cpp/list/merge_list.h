#pragma once

#include <string>
#include "list_node.h"
#include "base_list.h"

namespace pu {

class MergeList : public BaseList{
 public:
  MergeList()=default;

  std::string Merge1();
  ListNode* Merge(ListNode *l1,ListNode *l2);
  std::string MergeKLists();

 private:
  ListNode* InitList3();
  ListNode* DivideMerge(std::vector<ListNode*> list,int left,int right);
};

} // namespace pu
