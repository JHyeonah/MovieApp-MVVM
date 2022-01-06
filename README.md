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
- 상단의 SearchBar로 영화 검색 

## 영화 상세보기

![디테일](https://user-images.githubusercontent.com/38305511/148067820-75cd56df-145c-463d-b9f5-e8c526f01bbf.JPG)
![디테일 스크롤](https://user-images.githubusercontent.com/38305511/148067831-a915e652-8052-4052-9406-416f50e05b60.JPG)
- 영화 상세보기 화면
- 영화 제목, 스크린샷, 장르, 런타임, 배우 등 조회 
- 상단 Floating Action Button으로 영화 좋아요/좋아요 삭제 가능
- 하단으로 스크롤 시 스크린샷이 사라지는 애니메이션 적용 (CoordinatorLayout)

## 좋아요 리스트

![좋아요화면](https://user-images.githubusercontent.com/38305511/148070375-5a182626-20d1-4582-b6dd-4b02ffc3ae5b.JPG)
- 좋아요한 영화 모아보기 리스트
- 상세보기로 접근 가능

<br><br>사용한 API : https://yts.mx/api

## 사용한 라이브러리
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel?gclid=Cj0KCQiAw9qOBhC-ARIsAG-rdn6Cn4XG5lKtvLB2rzzSUjVCzmyDjz2ns9r268NRdFWmtONqABIRDv4aAmo9EALw_wcB&gclsrc=aw.ds) : UI 관련 데이터 저장, 관리 (AAC)
- [DataBinding](https://developer.android.com/topic/libraries/data-binding?hl=ko) : observable 데이터를 UI에 바인딩 (AAC)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata?hl=ko) : observable 데이터 홀더 클래스 (AAC)
- [Room](https://developer.android.com/jetpack/androidx/releases/room?gclid=Cj0KCQiAw9qOBhC-ARIsAG-rdn4_0bR_Z9VkKdS20RbYe4KRtoLby4PHF88aAVgvoutzPrKlpLnJNAIaAoTMEALw_wcB&gclsrc=aw.ds) : SQLite DB의 쉬운 사용을 위한 Object Relational Mapping 라이브러리 (AAC)
- [Navigation](https://developer.android.com/guide/navigation?gclid=Cj0KCQiAw9qOBhC-ARIsAG-rdn4nsI_gaV3fjtVk77NUv-R-zYFAS4vxa8wrIBdU8WmtrczAwihRZVcaAnmdEALw_wcB&gclsrc=aw.ds) : 앱 Fragment 간의 화면 이동 처리 (AAC)
- [ViewPager2](https://developer.android.com/jetpack/androidx/releases/viewpager2?hl=ko) : 탭 간 이동, 스크린샷 넘기기 
- [Coroutine](https://kotlinlang.org/docs/coroutines-overview.html) : 서버 통신 시 비동기 처리
- [Glide](https://github.com/bumptech/glide) : 이미지 처리
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) : 의존성 주입
- [Retrofit](https://square.github.io/retrofit/) : HTTP 통신 시 사용하는 라이브러리
