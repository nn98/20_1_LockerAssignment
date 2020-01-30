# 20_1_LockerAssignment
* * *
0102/
 - 단순 쓰레드.sleep은 뷰 인플레이션 없이 바로 대기하는듯?
  - try{
            Thread.sleep(2000);
        }catch (Exception e){

        }
        finish();
        startActivity(new Intent(BeginActivity.this,MainActivity.class)); 불가.
  - private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(BeginActivity.this,MainActivity.class));
            }
        }, 2000);
    }
 -- https://coding-factory.tistory.com/50

 - 스크롤뷰 > 하나의 자식 뷰만. > 레이아웃을 자식으로 넣고 레이아웃 속에 뷰s.
 -- https://yollo.tistory.com/6

@1 로딩화면, 층별 도면(예시) 생성.

 - 커스텀뷰 사용시도-실패
 -- https://gun0912.tistory.com/38

 - 수평 스크롤뷰 사용 시도
 -- https://m.blog.naver.com/PostView.nhn?blogId=sks6624&logNo=150175330937&proxyReferer=https%3A%2F%2Fwww.google.com%2F

 ? 스크롤뷰 사용시 orientation/descendant 필요? 아니면 Alaotdialog?

 - 이미지 비율 유지/크기 조정
 -- https://wimir-dev.tistory.com/5

@2 층별 도면 클릭시 정보 입력 폼으로 연결. 
TODO> 사물함 뷰 플레이팅 > 정보 입력 폼으로 연결

