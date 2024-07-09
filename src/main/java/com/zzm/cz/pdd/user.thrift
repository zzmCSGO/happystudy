
namespace java com.zzm

struct User{
    1:i32 id
    2:string name
    3:i32 age=0
}


service UserService{
    User getUserById(1:i32 id)
    bool isExist(1:string name)
}
