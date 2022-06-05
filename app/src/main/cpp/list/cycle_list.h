#pragma once

#include <string>
#include "list_node.h"
#include "base_list.h"

namespace pu {

class CycleList : public BaseList{
 public:
  CycleList()=default;
  std::string HasCycle();
  std::string EntryNodeOfLoop();
  std::string FindKthToTail(int k);
};

} // namespace pu
