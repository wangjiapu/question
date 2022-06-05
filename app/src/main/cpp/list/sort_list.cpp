#pragma once

#include "sort_list.h"

namespace pu {

SortList::SortList() {
  list_.push_back(2);
  list_.push_back(98);
  list_.push_back(4);
  list_.push_back(66);
  list_.push_back(66);
  list_.push_back(34);
  list_.push_back(212);
  list_.push_back(32);
  list_.push_back(54);
  list_.push_back(56);
}

std::string SortList::Sort(SortType type) {
  SortStrategy *strategy = nullptr;
  switch (type) {
  case SortType::kQuick: {
    strategy = new QuicklySort();
    break;
  }
  }
  if (strategy) {
    strategy->DoSort(list_);
    return ToString(list_);
  }
  return "error!";
}

std::string SortList::ToString(const std::vector<int> &list) {
  if (list.empty()){
    return "empty list!";
  }
  std::string ss;
  for (auto it:list){
    ss.append(std::to_string(it)+",");
  }
  return ss;
}

void QuicklySort::DoSort(std::vector<int> &list) {
  if (list.empty()) {
    return;
  }
  QSort(list, 0, list.size() - 1);
}

void QuicklySort::QSort(std::vector<int> &list, int start, int end) {
  if (start >= end) {
    // 终止条件
    return;
  }
  int flag = list.at(start);
  int i = start;
  int j = end;
  while (i < j) {
    while (i < j && list.at(j) >= flag) {
      j--;
    }
    Swap(list, i, j);
    while (i < j && list.at(i) <= flag) {
      i++;
    }
    Swap(list, i, j);
  }
  QSort(list, start, i);
  QSort(list, i + 1, end);
}

void SortStrategy::Swap(std::vector<int> &list, int i, int j) {
  int temp = list.at(i);
  list.at(i) = list.at(j);
  list.at(j) = temp;
}
} // namespace pu
