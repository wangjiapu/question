#pragma once
#include <string>

namespace pu{
class CMain{

 public:
  CMain()=default;
  std::string Run();

 private:
  std::string ReverseRun();
  std::string MergeRun();
  std::string SortRun();
  std::string CycleRun();

  std::string AddRun();
};
}