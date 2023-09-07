// 상세정보 & 관람평
const reviewContent = document.getElementById('reviewContent');
const charCount = document.getElementById('charCount');
const go2ticketing = document.getElementById('go2ticketing');

reviewContent.addEventListener('input', function() {
    const text = reviewContent.value;
    const remaining = 200 - text.length;

    charCount.textContent = text.length + ' / 200';

    if (remaining < 0) {
        charCount.textContent = '200 / 200';
    }
});

const newReviewBtn = document.querySelector("#newReviewBtn");
newReviewBtn?.addEventListener('click', () => {
    const reviewFrm = document.forms.reviewFrm;
    if (reviewFrm.userid.value === '') alert('로그인이 필요한 서비스입니다');
    else if (reviewFrm.reviewContent.value.length < 10) alert('관람평은 10글자 이상이어야 합니다');
    else if (reviewFrm.star.value === '') alert('별점을 선택해주세요');
    else {
        reviewFrm.method = 'post';
        reviewFrm.submit();
    }
});

go2ticketing?.addEventListener('click', () => {
    location.href = '/ticket/booking';
})



// 댓글 수정 모달 띄우기
let modal = null;
const showComment =  (rvno, revisedReviewContent, star) => {
    const frpno = document.querySelector("#rvno");
    const freply = document.querySelector("#revisedReviewContent");
    const modModal = document.querySelector("#modModal");
    const fstar = modModal.querySelector(`input[name="star"][value="${star}"]`);


    frpno.value = rvno;
    freply.value = revisedReviewContent;
    fstar.checked = true;

    let mymodal = null; // 대댓글 모달창 띄우기
    try{
        mymodal = new bootstrap.Modal(modModal,{});
        modal = mymodal;
    } catch (e){}

    mymodal.show();
};


//댓글 수정
const revisedReviewContent = document.getElementById('revisedReviewContent');
const charCount2 = document.getElementById('charCount2');

revisedReviewContent.addEventListener('input', function() {
    const text = revisedReviewContent.value;
    const remaining = 200 - text.length;

    charCount2.textContent = text.length + ' / 200';

    if (remaining < 0) {
        charCount2.textContent = '200 / 200';
    }
});

const reviseReviewBtn = document.querySelector("#reviseReviewBtn");
reviseReviewBtn?.addEventListener('click', () => {
    const reviseReviewFrm = document.forms.reviseReviewFrm;
    if (reviseReviewFrm.revisedReviewContent.value === '') alert('관람평을 작성해주세요');
    else if (reviseReviewFrm.star.value === '') alert('별점을 선택해주세요');
    else {
        reviseReviewFrm.method = 'post';
        reviseReviewFrm.action = '/movie/modify';
        reviseReviewFrm.submit();
    }
});


//댓글 삭제
function deleteComment(rvno, mvno){
    if (confirm('삭제하시겠습니까?') === true)
        location.href="/movie/delete?rvno=" + rvno + "&mvno=" + mvno;
    else return;
}


// const upup = document.querySelector("#upup");
// upup?.addEventListener('click', () => {
//     location.href="/movie/readStar?";
// });

// const tsales = document.querySelector("#tsales");
// tsales?.addEventListener('click', () => {
//     location.href="/movie/readTsales";
// });

// const ticketing = document.querySelector("#ticketing");
// ticketing?.addEventListener('click', () => {
//     location.href="/ticket/ticketing";
// });