
#include <iostream> 
using namespace std;

class Shape {
public: 
  string* name;
  float area;
public:
  Shape() {
    name = new string("shape");
    cout << "shape" << endl;
  }
};

int main() {
  Shape* s = new Shape();
  s-> area = 1.0;
  cout << s->name << endl;
  delete s;
}

