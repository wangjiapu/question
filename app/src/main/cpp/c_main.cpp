
#include "c_main.h"
#include "common/p_log.h"
#include "list/merge_list.h"
#include "list/reverse_list.h"
#include "list/sort_list.h"
#include "list/cycle_list.h"

namespace pu {

std::string CMain::Run() {
  PLOGD("list", "start!");
  int sw = 3;
  switch (sw) {
  case 0: {
    return ReverseRun();
  }
  case 1: {
    return MergeRun();
  }
  case 2: {
    return SortRun();
  }
  case 3: {
    return CycleRun();
  }
  }
  return "pppp";
}

std::string CMain::ReverseRun() {
  ReverseList reverse_list;
  // return "执行完成!"+reverse_list.ReverseAll();
  return "字符串区间翻转：" + reverse_list.ReverseBetween(2, 4);
}

std::string CMain::MergeRun() {
  MergeList merge_list;
  // return merge_list.Merge1();
  return merge_list.MergeKLists();
}

std::string CMain::SortRun() {
  SortList sort_list;
  return sort_list.Sort(SortType::kQuick);
}

std::string CMain::CycleRun() {
  CycleList cycle;
 // return  cycle.EntryNodeOfLoop();
  return cycle.FindKthToTail(2);
}


} // namespace pu
