// ------------------------------------------ find_id
const findByName = document.querySelector('#findByName');
const findByPhone = document.querySelector('#findByPhone');
const findIdBtn = document.querySelector('#findIdBtn');
const fdidmsg = document.querySelector('#fdidmsg');

findByName?.addEventListener('keydown', () => {
    const nmreg =  /[^ㄱ-ㅎㅏ-ㅣ가-힣]$/;
    if(nmreg.test(findByName.value)) {
        findByName.value = '';
        alert('한글만 입력할 수 있습니다');
    }
});

findByPhone?.addEventListener('keydown', () => {
    const phreg = /[^0-9]$/;
    if(phreg.test(findByPhone.value)) {
        findByPhone.value = '';
        alert('숫자만 입력할 수 있습니다');
    }
});

findByName?.addEventListener('blur', () => {
    if(findByName.value !== '' && findByPhone.value !== '') {
        findIdBtn.disabled = false;
    }
})

findByPhone?.addEventListener('blur', () => {
    if(findByName.value !== '' && findByPhone.value !== '') {
        findIdBtn.disabled = false;
    }
})

window.onload = function() {
	var httpRequest;
    console.log("window 됨");

	findIdBtn?.addEventListener('click', () => {
		httpRequest = new XMLHttpRequest();
        console.log("request 됨");
	    httpRequest.onreadystatechange = () => {
            console.log("onreadystatechange 됨");
		    if (httpRequest.readyState === XMLHttpRequest.DONE) {
                console.log("DONE 됨");
			    if (httpRequest.status === 200) {
					var result = httpRequest.response;
                    console.log("findByName : " + findByName.value);
                    console.log("findByPhone : " + findByPhone.value);
                    console.log("result.userid : " + result.userid);
                    console.log("result.regdate : " + result.regdate);
                    if(result.userid !== undefined && result.regdate !== undefined) {
                        const cutDate = (result.regdate).substr(0,10);
                        fdidmsg.innerText = '회원님의 아이디는 [' + result.userid + '] 입니다\n가입일 : ' + cutDate;

                        const clsIdBtn = document.querySelector('#clsIdBtn');
                        clsIdBtn?.addEventListener('click', () => { location.href = '/'; })

                        const chkIdBtn = document.querySelector('#chkIdBtn');
                        chkIdBtn?.addEventListener('click', () => { location.href = '/'; })
                    } else {
                        fdidmsg.innerText = '해당정보로 가입된 사용자를 찾을수 없습니다';
                    }
			    } else {
                    console.log("200 error!");
                }
		    } else {
                console.log("done error!");
            }
	    };
	    httpRequest.open('GET', '/join/getIdByNameAndPhone?findByName=' + findByName.value + '&findByPhone=' + findByPhone.value);
	    httpRequest.responseType = "json";
	    httpRequest.send();
	});
};



// ------------------------------------------ find_pass
const findByName2 = document.querySelector('#findByName2');
const findByPhone2 = document.querySelector('#findByPhone2');
const findPassBtn = document.querySelector('#findPassBtn');
const fdpassmsg = document.querySelector('#fdpassmsg');

findByName2?.addEventListener('keydown', () => {
    const nmreg =  /[^ㄱ-ㅎㅏ-ㅣ가-힣]$/;
    if(nmreg.test(findByName2.value)) {
        findByName2.value = '';
        alert('한글만 입력할 수 있습니다');
    }
});

findByPhone2?.addEventListener('keydown', () => {
    const phreg = /[^0-9]$/;
    if(phreg.test(findByPhone2.value)) {
        findByPhone2.value = '';
        alert('숫자만 입력할 수 있습니다');
    }
});

findByName2?.addEventListener('blur', () => {
    if(findByName2.value !== '' && findByPhone2.value !== '') {
        findPassBtn.disabled = false;
    }
})

findByPhone2?.addEventListener('blur', () => {
    if(findByName2.value !== '' && findByPhone2.value !== '') {
        findPassBtn.disabled = false;
    }
})

window.onload = function() {
	var httpRequest;
    console.log("window 됨");

	findPassBtn?.addEventListener('click', () => {
		httpRequest = new XMLHttpRequest();
        console.log("request 됨");
	    httpRequest.onreadystatechange = () => {
            console.log("onreadystatechange 됨");
		    if (httpRequest.readyState === XMLHttpRequest.DONE) {
                console.log("DONE 됨");
			    if (httpRequest.status === 200) {
					var result = httpRequest.response;
                    console.log("findByName : " + findByName.value);
                    console.log("findByPhone : " + findByPhone.value);
                    console.log("result.userid : " + result.userid);
                    console.log("result.regdate : " + result.regdate);
                    if(result.userid !== undefined && result.regdate !== undefined) {
                        const cutDate = (result.regdate).substr(0,10);
                        fdidmsg.innerText = '회원님의 아이디는 [' + result.userid + '] 입니다\n가입일 : ' + cutDate;

                        const clsIdBtn = document.querySelector('#clsIdBtn');
                        clsIdBtn?.addEventListener('click', () => { location.href = '/'; })

                        const chkIdBtn = document.querySelector('#chkIdBtn');
                        chkIdBtn?.addEventListener('click', () => { location.href = '/'; })
                    } else {
                        fdidmsg.innerText = '해당정보로 가입된 사용자를 찾을수 없습니다';
                    }
			    } else {
                    console.log("200 error!");
                }
		    } else {
                console.log("done error!");
            }
	    };
	    httpRequest.open('GET', '/join/getIdByNameAndPhone?findByName=' + findByName.value + '&findByPhone=' + findByPhone.value);
	    httpRequest.responseType = "json";
	    httpRequest.send();
	});
};



// ------------------------------------------ policy
// 이용약관 체크박스
const agreeone = document.querySelector('#agreeone');

// 개인정보 이용 체크박스
let agreetwo = document.querySelector('#agreetwo');

// 동의 버튼
const okagree = document.querySelector('#okagree');
okagree?.addEventListener('click', () => {
    if (!agreeone.checked) alert("이용약관 동의에 체크하세요");
    else if (!agreetwo.checked) alert("개인정보 이용 동의에 동의하세요");
    else location.href = '/join/signup';
});

// 미동의 버튼
const noagree = document.querySelector('#noagree');
noagree?.addEventListener('click', () => {
    location.href = '/';
});

// --------------------------------------------- signup
const joinfrm = document.forms.joinfrm;
const joinbtn = document.querySelector('#joinbtn');
const email3 = document.querySelector('#email3');
const userid = document.querySelector('#userid');
const uidmsg = document.querySelector('#uidmsg');
const pwdmsg = document.querySelector('#pwdmsg');
const passwd = document.querySelector('#passwd');
const repasswd = document.querySelector('#repasswd');
const usrnm = document.querySelector('#name');

let modal = null;

joinbtn?.addEventListener('click', () => {
    if(joinfrm.userid.value == '') alert('아이디를 입력하세요');
    else if(joinfrm.name.value == '') alert('이름을 입력하세요');
    else if(joinfrm.passwd.value == '') alert('비밀번호를 입력하세요');
    else if(joinfrm.repasswd.value == '') alert('비밀번호를 확인을 입력하세요');
    else if(joinfrm.repasswd.value != joinfrm.passwd.value) alert('비밀번호가 서로 일치하지 않습니다');
    else if(joinfrm.email1.value == '' || joinfrm.email2.value == '') alert('이메일을 입력하세요');
    else if(joinfrm.tel2.value == '' || joinfrm.tel3.value == '') alert('전화번호를 입력하세요');
    else if(uidmsg.style.color !== 'white') alert('아이디 중복 체크를 하세요');
    else{
        joinfrm.email.value = joinfrm.email1.value + '@' + joinfrm.email2.value;
        joinfrm.phone.value = joinfrm.tel1.value + joinfrm.tel2.value + joinfrm.tel3.value;

        joinfrm.method = 'post';
        joinfrm.action = '/join/signup';
        joinfrm.submit();
    }
});

email3?.addEventListener('change', () => {
    if (email3.value === '직접입력하기'){
        joinfrm.email2.readOnly = false;
        joinfrm.email2.value = '';
    }else if(email3.value !== '선택하세요'){
        joinfrm.email2.readOnly = true;
        joinfrm.email2.value = email3.value;

    }
});

usrnm?.addEventListener('keypress', () => {
    const nmreg =  /^[ㄱ-ㅎ가-힣]+$/;
    if(nmreg.test(usrnm.value) === false) {
        usrnm.value = '';
        alert('한글만 입력할 수 있습니다');
    }
});

userid?.addEventListener('blur', () =>{
    uidmsg.innerText = '';
    const idreg2 = /^[a-zA-Z0-9]{6,11}$/;
    if(userid.value !== '' && idreg2.test(userid.value) === false){
        uidmsg.innerText = '6~12자 이내 영문, 숫자 조합이어야 합니다';
        uidmsg.style.color = '#f0ad4e';
    } else if(idreg2.test(userid) === true){
        uidmsg.innerText = '';
    }
});

const chkDupBtn = document.querySelector('#chkDupBtn');
window.onload = function() {
	var httpRequest;
	chkDupBtn?.addEventListener('click', () => {
		httpRequest = new XMLHttpRequest();
	    httpRequest.onreadystatechange = () => {
		    if (httpRequest.readyState === XMLHttpRequest.DONE) {
			    if (httpRequest.status === 200) {
					var result = httpRequest.response;
                    console.log("result : " + result);
                    if(result) {
                        uidmsg.innerText = '사용 불가능한 아이디입니다';
                        uidmsg.style.color = '#f0ad4e';
                    } else {
                        uidmsg.innerText = '사용 가능한 아이디입니다';
                        uidmsg.style.color = 'whtie';
                    }
			    }
		    }
	    };
	    httpRequest.open('GET', '/join/checkUserid?userid=' + userid.value);
	    httpRequest.responseType = "json";
	    httpRequest.send();
	});
};

chkDupBtn?.addEventListener('click', () => {
    if(userid.value !== '') {
        uidmsg.innerText = '사용 가능한 아이디입니다';
        uidmsg.style.color = 'white';
    } else {
        uidmsg.innerText = '사용하실 아이디를 입력해주세요';
        uidmsg.style.color = '#f0ad4e';
    }
});

passwd?.addEventListener('blur', () => {
    const pwdreg = /[a-zA-Z0-9_-]{6,15}/;
    if(passwd.value !== '' && pwdreg.test(passwd.value)) {
        pwdmsg.innerText = '';
        repasswd.readOnly = false;
    } else if (passwd.value !== '') {
        pwdmsg.innerText = '6~16 자의 영문, 숫자, 특수기호(_-) 조합이어야 합니다';
        pwdmsg.style.color = '#f0ad4e';
    }
});

repasswd?.addEventListener('blur', () => {
    let pmsg = '비밀번호가 서로 일치하지 않습니다';
    pwdmsg.style.color = '#f0ad4e';
    if((repasswd.value === joinfrm.passwd.value) && repasswd.value !== '') {
        pmsg = '비밀번호가 서로 일치합니다';
        pwdmsg.style.color = 'white';
    } else if (joinfrm.passwd.value === '' || repasswd.value === '') {
        pmsg = '';
    }
    pwdmsg.innerText = pmsg;
});

// --------------------------------------------- joinok
const go2index = document.querySelector('#go2index');
go2index?.addEventListener('click', () => {
    location.href = '/';
});