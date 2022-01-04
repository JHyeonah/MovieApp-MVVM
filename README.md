# MovieApp-MVVM
**Movie Api를 이용해 MVVM 방식으로 구현한 Toy App**  
영화 정보 검색, 저장, 정보 열람 등의 기능  
<br>

## 메인화면

![영화리스트](https://user-images.githubusercontent.com/38305511/148065572-537c808f-72a5-4d12-8d01-191c43ee4643.JPG)
- 영화 리스트 표시
- 20개씩 무한 스크롤 가능  

## 영화 검색

![검색](https://user-images.githubusercontent.com/38305511/148066741-e2d5ef76-499b-4aa5-bb61-711b2694a866.JPG)
- 영화 검색 기능
- 상단의 SearchBar로 영화 검색 가능  

## 영화 상세보기

![디테일](https://user-images.githubusercontent.com/38305511/148067820-75cd56df-145c-463d-b9f5-e8c526f01bbf.JPG)
![디테일 스크롤](https://user-images.githubusercontent.com/38305511/148067831-a915e652-8052-4052-9406-416f50e05b60.JPG)
- 영화 상세보기 화면
- 영화 제목, 스크린샷, 장르, 런타임, 배우 등 조회 
- 상단 Floating Action Button으로 영화 좋아요/좋아요 삭제 가능
- 하단으로 스크롤 시 스크린샷이 사라지는 애니메이션 적용

## 좋아요 리스트

![좋아요화면](https://user-images.githubusercontent.com/38305511/148070375-5a182626-20d1-4582-b6dd-4b02ffc3ae5b.JPG)
- 좋아요한 영화 모아보기 리스트
- 상세보기로 접근 가능

<br><br>사용한 API : https://yts.mx/api

## 사용한 라이브러리
- ViewModel : 
- DataBinding : observable 데이터를 UI에 바인딩
- LiveData : 
- Flow : 
- Room : 영화 데이터 저장을 위한 Database
- Navigation : 앱 Fragment 간의 화면 이동 처리
- ViewPager2 : 탭 간 이동, 스크린샷 넘기기 
- [Coroutine](https://kotlinlang.org/docs/coroutines-overview.html) : 서버 통신, 비동기 처리
- [Glide](https://github.com/bumptech/glide) : 이미지 처리
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) : 의존성 주입
         
