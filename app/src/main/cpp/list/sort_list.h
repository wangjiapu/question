#pragma once

#include "base_list.h"
#include "list_node.h"
#include <string>

namespace pu {

enum class SortType {
  kNode = 0,
  kQuick = 1,
};

class SortList {
public:
  SortList();

  std::string Sort(SortType type);

private:
  std::string ToString(const std::vector<int> &list);
  std::vector<int> list_;
};

class SortStrategy {
public:
  SortStrategy() = default;
  virtual void DoSort(std::vector<int> &list) = 0;
  void Swap(std::vector<int> & list,int i,int j);
};

class QuicklySort : public SortStrategy {
public:
  QuicklySort() = default;
  void DoSort(std::vector<int> &list) override;

 private:
  void QSort(std::vector<int> & list,int start,int end);
};

} // namespace pu
