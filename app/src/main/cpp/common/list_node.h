#pragma once

#include <string>
#include <vector>

namespace pu {

struct ListNode {
    int val;
    struct ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

} // namespace pu
