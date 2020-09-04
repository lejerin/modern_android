## modern_android with jetpack
android study  

# Room

# LiveData

# ViewModel
ViewModelProvider.of() was deprecated  
- java   
 if(viewModelFactory == null){
            viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        }
        MainViewModel viewModel =  new ViewModelProvider(this,viewModelFactory).get(MainViewModel.class);  
          
 - kotlin  
 
  val viewModel: MainViewModel by viewModels()

# Git

git config --global user.email "이메일주소"  
git config --global user.name "이름"  

cd {folder}  
git init  

  
git status  
git add *  
git commit -m "커밋내용"  

  
git remote add 원격저장소별칭 "자신의 git 주소"  
git pull --rebase 원격저장소별칭 master  
git push 원격저장소별칭 master

  

