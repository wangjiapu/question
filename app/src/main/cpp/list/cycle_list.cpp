

#include"cycle_list.h"

namespace pu {

std::string CycleList::HasCycle() {
  ListNode * p_head=GetCycleList();
  if (!p_head){
    return nullptr;
  }
  ListNode * p1=p_head;
  ListNode* p2=p_head;
  while (p2 && p2->next){
    p2=p2->next->next;
    p1=p1->next;
    if (p1==p2){
      return "true";
    }
  }
  return "false";
}

std::string CycleList::EntryNodeOfLoop() {
  ListNode * head=GetCycleList();
  if (!head){
    return "nullptr";
  }
  ListNode* fast_p=head;
  ListNode* slow_p=head;
  while (fast_p && fast_p->next){
    fast_p=fast_p->next->next;
    slow_p=slow_p->next;
    if (slow_p == fast_p){
      break;
    }
  }
  if (!fast_p || !fast_p->next){
    return "nullptr";
  }
  fast_p=head;
  while (fast_p !=slow_p){
    fast_p=fast_p->next;
    slow_p=slow_p->next;
  }
  return "std::to_string(fast_p->val)";
}

} // namespace pu
