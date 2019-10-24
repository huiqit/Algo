
#include <iostream> 
using namespace std;

class Shape {
public: 
  string* name = NULL;
  float area;
public:
  Shape() {
    name = new string("shape");
    cout << "shape" << endl;
  }
  ~Shape() {
    cout << "destructor" << endl;
    if(name) {
      delete name;
    }
  }
};

int main() {
  Shape* s = new Shape();
  s-> area = 1.0;
  cout << s->name << endl;
  delete s;
}

