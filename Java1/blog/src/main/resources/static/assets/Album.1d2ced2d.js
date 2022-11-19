import{x as Ee,W as B,a1 as ve,N as ce,bc as he,ah as me,a4 as ne,bm as ge,bn as Ae,bo as ze,aO as _e,a6 as we,aA as Ne,a8 as z,bp as Ve,aQ as Oe,O as N,Q as de,ak as be,R as ye,o as w,d as U,e as n,w as u,f as m,ad as I,a2 as e,ae as pe,aN as Se,q as x,a_ as T,ba as Te,g as C,F as X,bq as Re,br as De,bs as je,be as Me,ao as Pe,bt as Be,bu as Ue,h as ae,ac as Ie,af as ke,an as le,T as He,aE as Fe,ag as Le,aa as Y,aC as F,bv as Ye,aq as xe,bw as Xe,bx as qe,ay as We,aw as Ke,bb as Ze,by as $e,t as Ce,bz as Qe,_ as Ge,bA as Je,E as fe,A as et,l as tt,m as st,n as at,r as lt,k as nt,p as ot,j as K,i as it,s as rt,u as ut}from"./index.8ad34794.js";import{d as ct,b as dt,E as pt,a as mt,c as gt}from"./el-select.f397a1f7.js";import"./el-tag.f224c1ec.js";var ft="Expected a function";function ue(o,t,r){var i=!0,a=!0;if(typeof o!="function")throw new TypeError(ft);return Ee(r)&&(i="leading"in r?!!r.leading:i,a="trailing"in r?!!r.trailing:a),ct(o,t,{leading:i,maxWait:t,trailing:a})}const vt=(o,t)=>{if(!B||!o||!t)return!1;const r=o.getBoundingClientRect();let i;return t instanceof Element?i=t.getBoundingClientRect():i={top:0,right:window.innerWidth,bottom:window.innerHeight,left:0},r.top<i.bottom&&r.bottom>i.top&&r.right>i.left&&r.left<i.right},ht=()=>B&&/firefox/i.test(window.navigator.userAgent),_t=ve({urlList:{type:ce(Array),default:()=>he([])},zIndex:{type:Number},initialIndex:{type:Number,default:0},infinite:{type:Boolean,default:!0},hideOnClickModal:{type:Boolean,default:!1},teleported:{type:Boolean,default:!1},closeOnPressEscape:{type:Boolean,default:!0}}),wt={close:()=>!0,switch:o=>me(o)},bt=["src"],yt=ne({name:"ElImageViewer"}),It=ne({...yt,props:_t,emits:wt,setup(o,{expose:t,emit:r}){const i=o,a={CONTAIN:{name:"contain",icon:ge(Ae)},ORIGINAL:{name:"original",icon:ge(ze)}},f=ht()?"DOMMouseScroll":"mousewheel",{t:d}=_e(),p=we("image-viewer"),{nextZIndex:b}=Ne(),y=z(),L=z([]),R=Ve(),k=z(!0),_=z(i.initialIndex),D=Oe(a.CONTAIN),h=z({scale:1,deg:0,offsetX:0,offsetY:0,enableTransition:!1}),j=N(()=>{const{urlList:s}=i;return s.length<=1}),M=N(()=>_.value===0),g=N(()=>_.value===i.urlList.length-1),V=N(()=>i.urlList[_.value]),oe=N(()=>{const{scale:s,deg:c,offsetX:v,offsetY:E,enableTransition:O}=h.value;let A=v/s,S=E/s;switch(c%360){case 90:case-270:[A,S]=[S,-A];break;case 180:case-180:[A,S]=[-A,-S];break;case 270:case-90:[A,S]=[-S,A];break}const H={transform:`scale(${s}) rotate(${c}deg) translate(${A}px, ${S}px)`,transition:O?"transform .3s":""};return D.value.name===a.CONTAIN.name&&(H.maxWidth=H.maxHeight="100%"),H}),$=N(()=>me(i.zIndex)?i.zIndex:b());function P(){re(),r("close")}function ie(){const s=ue(v=>{switch(v.code){case F.esc:i.closeOnPressEscape&&P();break;case F.space:ee();break;case F.left:te();break;case F.up:l("zoomIn");break;case F.right:se();break;case F.down:l("zoomOut");break}}),c=ue(v=>{(v.wheelDelta?v.wheelDelta:-v.detail)>0?l("zoomIn",{zoomRate:1.2,enableTransition:!1}):l("zoomOut",{zoomRate:1.2,enableTransition:!1})});R.run(()=>{Y(document,"keydown",s),Y(document,f,c)})}function re(){R.stop()}function Q(){k.value=!1}function G(s){k.value=!1,s.target.alt=d("el.image.error")}function J(s){if(k.value||s.button!==0||!y.value)return;h.value.enableTransition=!1;const{offsetX:c,offsetY:v}=h.value,E=s.pageX,O=s.pageY,A=ue(H=>{h.value={...h.value,offsetX:c+H.pageX-E,offsetY:v+H.pageY-O}}),S=Y(document,"mousemove",A);Y(document,"mouseup",()=>{S()}),s.preventDefault()}function q(){h.value={scale:1,deg:0,offsetX:0,offsetY:0,enableTransition:!1}}function ee(){if(k.value)return;const s=Ye(a),c=Object.values(a),v=D.value.name,O=(c.findIndex(A=>A.name===v)+1)%s.length;D.value=a[s[O]],q()}function W(s){const c=i.urlList.length;_.value=(s+c)%c}function te(){M.value&&!i.infinite||W(_.value-1)}function se(){g.value&&!i.infinite||W(_.value+1)}function l(s,c={}){if(k.value)return;const{zoomRate:v,rotateDeg:E,enableTransition:O}={zoomRate:1.4,rotateDeg:90,enableTransition:!0,...c};switch(s){case"zoomOut":h.value.scale>.2&&(h.value.scale=Number.parseFloat((h.value.scale/v).toFixed(3)));break;case"zoomIn":h.value.scale<7&&(h.value.scale=Number.parseFloat((h.value.scale*v).toFixed(3)));break;case"clockwise":h.value.deg+=E;break;case"anticlockwise":h.value.deg-=E;break}h.value.enableTransition=O}return de(V,()=>{be(()=>{const s=L.value[0];s!=null&&s.complete||(k.value=!0)})}),de(_,s=>{q(),r("switch",s)}),ye(()=>{var s,c;ie(),(c=(s=y.value)==null?void 0:s.focus)==null||c.call(s)}),t({setActiveItem:W}),(s,c)=>(w(),U(Fe,{to:"body",disabled:!s.teleported},[n(He,{name:"viewer-fade",appear:""},{default:u(()=>[m("div",{ref_key:"wrapper",ref:y,tabindex:-1,class:I(e(p).e("wrapper")),style:pe({zIndex:e($)})},[m("div",{class:I(e(p).e("mask")),onClick:c[0]||(c[0]=Se(v=>s.hideOnClickModal&&P(),["self"]))},null,2),x(" CLOSE "),m("span",{class:I([e(p).e("btn"),e(p).e("close")]),onClick:P},[n(e(T),null,{default:u(()=>[n(e(Te))]),_:1})],2),x(" ARROW "),e(j)?x("v-if",!0):(w(),C(X,{key:0},[m("span",{class:I([e(p).e("btn"),e(p).e("prev"),e(p).is("disabled",!s.infinite&&e(M))]),onClick:te},[n(e(T),null,{default:u(()=>[n(e(Re))]),_:1})],2),m("span",{class:I([e(p).e("btn"),e(p).e("next"),e(p).is("disabled",!s.infinite&&e(g))]),onClick:se},[n(e(T),null,{default:u(()=>[n(e(De))]),_:1})],2)],64)),x(" ACTIONS "),m("div",{class:I([e(p).e("btn"),e(p).e("actions")])},[m("div",{class:I(e(p).e("actions__inner"))},[n(e(T),{onClick:c[1]||(c[1]=v=>l("zoomOut"))},{default:u(()=>[n(e(je))]),_:1}),n(e(T),{onClick:c[2]||(c[2]=v=>l("zoomIn"))},{default:u(()=>[n(e(Me))]),_:1}),m("i",{class:I(e(p).e("actions__divider"))},null,2),n(e(T),{onClick:ee},{default:u(()=>[(w(),U(Pe(e(D).icon)))]),_:1}),m("i",{class:I(e(p).e("actions__divider"))},null,2),n(e(T),{onClick:c[3]||(c[3]=v=>l("anticlockwise"))},{default:u(()=>[n(e(Be))]),_:1}),n(e(T),{onClick:c[4]||(c[4]=v=>l("clockwise"))},{default:u(()=>[n(e(Ue))]),_:1})],2)],2),x(" CANVAS "),m("div",{class:I(e(p).e("canvas"))},[(w(!0),C(X,null,ae(s.urlList,(v,E)=>Ie((w(),C("img",{ref_for:!0,ref:O=>L.value[E]=O,key:v,src:v,style:pe(e(oe)),class:I(e(p).e("img")),onLoad:Q,onError:G,onMousedown:J},null,46,bt)),[[ke,E===_.value]])),128))],2),le(s.$slots,"default")],6)]),_:3})],8,["disabled"]))}});var kt=Le(It,[["__file","/home/runner/work/element-plus/element-plus/packages/components/image-viewer/src/image-viewer.vue"]]);const Lt=xe(kt),xt=ve({hideOnClickModal:{type:Boolean,default:!1},src:{type:String,default:""},fit:{type:String,values:["","contain","cover","fill","none","scale-down"],default:""},loading:{type:String,values:["eager","lazy"]},lazy:{type:Boolean,default:!1},scrollContainer:{type:ce([String,Object])},previewSrcList:{type:ce(Array),default:()=>he([])},previewTeleported:{type:Boolean,default:!1},zIndex:{type:Number},initialIndex:{type:Number,default:0},infinite:{type:Boolean,default:!0},closeOnPressEscape:{type:Boolean,default:!0}}),Ct={load:o=>o instanceof Event,error:o=>o instanceof Event,switch:o=>me(o),close:()=>!0,show:()=>!0},Et=["src","loading"],At={key:0},zt=ne({name:"ElImage",inheritAttrs:!1}),Nt=ne({...zt,props:xt,emits:Ct,setup(o,{emit:t}){const r=o;let i="";const{t:a}=_e(),f=we("image"),d=Xe(),p=qe(),b=z(),y=z(!1),L=z(!0),R=z(!1),k=z(),_=z(),D=B&&"loading"in HTMLImageElement.prototype;let h,j;const M=N(()=>d.style),g=N(()=>{const{fit:l}=r;return B&&l?{objectFit:l}:{}}),V=N(()=>{const{previewSrcList:l}=r;return Array.isArray(l)&&l.length>0}),oe=N(()=>{const{previewSrcList:l,initialIndex:s}=r;let c=s;return s>l.length-1&&(c=0),c}),$=N(()=>r.loading==="eager"?!1:!D&&r.loading==="lazy"||r.lazy),P=()=>{!B||(L.value=!0,y.value=!1,b.value=r.src)};function ie(l){L.value=!1,y.value=!1,t("load",l)}function re(l){L.value=!1,y.value=!0,t("error",l)}function Q(){vt(k.value,_.value)&&(P(),q())}const G=Qe(Q,200);async function J(){var l;if(!B)return;await be();const{scrollContainer:s}=r;Ke(s)?_.value=s:Ze(s)&&s!==""?_.value=(l=document.querySelector(s))!=null?l:void 0:k.value&&(_.value=$e(k.value)),_.value&&(h=Y(_,"scroll",G),setTimeout(()=>Q(),100))}function q(){!B||!_.value||!G||(h==null||h(),_.value=void 0)}function ee(l){if(!!l.ctrlKey){if(l.deltaY<0)return l.preventDefault(),!1;if(l.deltaY>0)return l.preventDefault(),!1}}function W(){!V.value||(j=Y("wheel",ee,{passive:!1}),i=document.body.style.overflow,document.body.style.overflow="hidden",R.value=!0,t("show"))}function te(){j==null||j(),document.body.style.overflow=i,R.value=!1,t("close")}function se(l){t("switch",l)}return de(()=>r.src,()=>{$.value?(L.value=!0,y.value=!1,q(),J()):P()}),ye(()=>{$.value?J():P()}),(l,s)=>(w(),C("div",{ref_key:"container",ref:k,class:I([e(f).b(),l.$attrs.class]),style:pe(e(M))},[b.value!==void 0&&!y.value?(w(),C("img",We({key:0},e(p),{src:b.value,loading:l.loading,style:e(g),class:[e(f).e("inner"),e(V)&&e(f).e("preview"),L.value&&e(f).is("loading")],onClick:W,onLoad:ie,onError:re}),null,16,Et)):x("v-if",!0),L.value||y.value?(w(),C("div",{key:1,class:I(e(f).e("wrapper"))},[L.value?le(l.$slots,"placeholder",{key:0},()=>[m("div",{class:I(e(f).e("placeholder"))},null,2)]):y.value?le(l.$slots,"error",{key:1},()=>[m("div",{class:I(e(f).e("error"))},Ce(e(a)("el.image.error")),3)]):x("v-if",!0)],2)):x("v-if",!0),e(V)?(w(),C(X,{key:2},[R.value?(w(),U(e(Lt),{key:0,"z-index":l.zIndex,"initial-index":e(oe),infinite:l.infinite,"url-list":l.previewSrcList,"hide-on-click-modal":l.hideOnClickModal,teleported:l.previewTeleported,"close-on-press-escape":l.closeOnPressEscape,onClose:te,onSwitch:se},{default:u(()=>[l.$slots.viewer?(w(),C("div",At,[le(l.$slots,"viewer")])):x("v-if",!0)]),_:3},8,["z-index","initial-index","infinite","url-list","hide-on-click-modal","teleported","close-on-press-escape"])):x("v-if",!0)],64)):x("v-if",!0)],6))}});var Vt=Le(Nt,[["__file","/home/runner/work/element-plus/element-plus/packages/components/image/src/image.vue"]]);const Ot=xe(Vt);const St={components:{Plus:Je},props:{},data(){return{album:[{id:1,name:"\u5168\u90E8",coverImg:"src/img/1.png"},{id:2,name:"\u4EBA\u7269",coverImg:"src/img/2.png"},{id:3,name:"\u98CE\u666F",coverImg:"src/img/3.png"},{id:4,name:"\u79D1\u5E7B",coverImg:"src/img/5.jpg"}],photos1:[{img:"src/img/p1.png",realImg:"src/img/1.png"},{img:"src/img/p2.jpg",realImg:"src/img/1.png"},{img:"src/img/p3.jpg",realImg:"src/img/1.png"},{img:"src/img/p4.jpg",realImg:"src/img/1.png"},{img:"src/img/p1.png",realImg:"src/img/1.png"},{img:"src/img/p2.jpg",realImg:"src/img/1.png"},{img:"src/img/p3.jpg",realImg:"src/img/1.png"},{img:"src/img/p4.jpg",realImg:"src/img/1.png"}],realImg:["src/img/p1.png","src/img/p2.jpg","src/img/p3.jpg","src/img/p4.jpg","src/img/p1.png","src/img/p2.jpg","src/img/p3.jpg","src/img/p4.jpg"],progress:{percentage:0,show:!1,status:""},albumName:"",newAlbum:"",albums:["\u4EBA\u7269","\u98CE\u666F","\u79D1\u5E7B"],isfull:!1,uploadDialog:!1,fileList:[],dialogImageUrl:"",dialogVisible:!1}},methods:{addAlbum(){this.albums.push(this.newAlbum),this.albumName=this.newAlbum,this.newAlbum=""},handleRemove(o,t){console.log(o,t)},handlePictureCardPreview(o){this.dialogImageUrl=o.url,this.dialogVisible=!0},dealImage(o){var t=new Image,r=.9;t.src=o,t.setAttribute("crossOrigin","Anonymous");var i,a;return new Promise(f=>{t.onload=async function(){i=this.width,a=this.height;var d=document.createElement("canvas"),p=d.getContext("2d");let b=1920;Math.max(i,a)>b?i>a?(d.width=b,d.height=b*a/i):(d.height=b,d.width=b*i/a):(d.width=i,d.height=a,r=1),p.clearRect(0,0,d.width,d.height),p.drawImage(this,0,0,d.width,d.height);for(var y=d.toDataURL("image/jpeg",r);y.length/1024>500;)r-=.05,y=d.toDataURL("image/jpeg",r);f(y)}})},uploadHandler(o){o.file},exceedHandler(){fe({showClose:!0,message:"\u56FE\u7247\u6570\u91CF\u8D85\u51FA\u9650\u5236",type:"warning"})},upload(){if(this.albumName==""){fe({showClose:!0,message:"\u8BF7\u9009\u62E9\u76F8\u518C",type:"warning"});return}this.progress.show=!0,this.progress.percentage=0;let o=Math.round(1/this.fileList.length*100);this.fileList.forEach(t=>{if(t.status=="ready"){t.status="uploading",t.percentage=Math.round(20*Math.random());let r={albumName:this.albumName,simplifyImg:"",originalImg:""},i=new FileReader;i.readAsDataURL(t.raw),i.onload=async a=>{r.originalImg=a.target.result,r.simplifyImg=await this.dealImage(a.target.result)},console.log(r),et.post("album/add",r).then(a=>{a.code==200?(t.status="success",this.progress.percentage+o>95?(this.progress.percentage=100,this.progress.status="success"):this.progress.percentage+=o):(t.status="fail",this.progress.status="warning")}).catch(a=>{t.status="fail",this.progress.status="exception"})}})},clearAll(){this.fileList=[]},clearUpload(){let o=this.fileList.length;for(let t=0;t<o;t++)this.fileList[t].status=="success"&&(this.fileList.splice(t,1),t--,o--)},close(){this.uploadDialog=!1,this.progress.show=!1,this.progress.status="",this.progress.percentage=0}},computed:{isLogin:{set(o){this.$store.state.isLogin=o},get(){return this.$store.state.isLogin}}},watch:{},mounted(){}},Z=o=>(rt("data-v-abadd73b"),o=o(),ut(),o),Tt={style:{margin:"0 0 1% 2.5%",height:"30px",opacity:"0.7"}},Rt=["src"],Dt=Z(()=>m("span",{class:"fenlei"},"\u5206\u7C7B",-1)),jt=Z(()=>m("hr",{class:"line",align:"center"},null,-1)),Mt={class:"jutifenlei"},Pt=Z(()=>m("hr",{width:"100%",align:"left"},null,-1)),Bt=Z(()=>m("span",null,"\u7CBE\u9009",-1)),Ut=Z(()=>m("hr",{width:"100%",align:"right"},null,-1)),Ht={style:{"margin-left":"2%"}},Ft={style:{margin:"2% 0 0 2%"}},Yt={style:{display:"inline-block","margin-left":"2%","max-width":"150px"}},Xt={style:{margin:"0 15px"}},qt={style:{"margin-top":"2%"}},Wt={class:"previewDialog"},Kt=["src"];function Zt(o,t,r,i,a,f){const d=tt,p=st,b=at,y=Ot,L=lt("Plus"),R=T,k=dt,_=pt,D=nt,h=mt,j=gt,M=ot;return w(),C("div",null,[n(b,{style:{"margin-top":"50px"}},{default:u(()=>[n(d,{class:"space"}),n(d,{class:"container"},{default:u(()=>[n(b,null,{default:u(()=>[m("div",Tt,[f.isLogin?(w(),U(p,{key:0,type:"primary",onClick:t[0]||(t[0]=g=>a.uploadDialog=!0)},{default:u(()=>[K("\u4E0A\u4F20")]),_:1})):x("",!0)])]),_:1}),n(b,{class:"header"},{default:u(()=>[(w(!0),C(X,null,ae(a.album,g=>(w(),U(d,{class:"item",key:g.id},{default:u(()=>[m("img",{class:"cover",src:g.coverImg},null,8,Rt),Dt,jt,m("span",Mt,Ce(g.name),1)]),_:2},1024))),128))]),_:1}),n(b,{class:"fengexian"},{default:u(()=>[n(d,{span:1}),n(d,{span:10,style:{margin:"1% 0"}},{default:u(()=>[Pt]),_:1}),n(d,{span:2,style:{color:"deeppink",margin:"1% 0"}},{default:u(()=>[Bt]),_:1}),n(d,{span:10,style:{margin:"1% 0"}},{default:u(()=>[Ut]),_:1}),n(d,{span:1})]),_:1}),n(b,{class:"body"},{default:u(()=>[(w(!0),C(X,null,ae(a.photos1,(g,V)=>(w(),U(d,{class:"item",key:V},{default:u(()=>[n(y,{class:"photo",src:g.img,"preview-src-list":a.realImg,fit:"cover","initial-index":V,"preview-teleported":!0,"hide-on-click-modal":!0},null,8,["src","preview-src-list","initial-index"])]),_:2},1024))),128))]),_:1})]),_:1}),n(d,{class:"space"})]),_:1}),n(M,{modelValue:a.uploadDialog,"onUpdate:modelValue":t[5]||(t[5]=g=>a.uploadDialog=g),top:"60px",width:"64%",style:{"min-width":"820px","border-radius":"20px"},"close-on-click-modal":!1,"close-on-press-escape":!1,"append-to-body":!0},{default:u(()=>[m("div",Ht,[n(k,{"file-list":a.fileList,"onUpdate:file-list":t[1]||(t[1]=g=>a.fileList=g),ref:"uploadRef","list-type":"picture-card","on-preview":f.handlePictureCardPreview,"on-remove":f.handleRemove,"http-request":f.uploadHandler,"on-exceed":f.exceedHandler,multiple:"",limit:50},{default:u(()=>[n(R,null,{default:u(()=>[n(L)]),_:1})]),_:1},8,["file-list","on-preview","on-remove","http-request","on-exceed"])]),m("div",Ft,[n(p,{type:"primary",onClick:f.upload},{default:u(()=>[K("\u4E0A\u4F20")]),_:1},8,["onClick"]),n(p,{type:"primary",onClick:f.clearAll},{default:u(()=>[K("\u6E05\u7A7A\u5168\u90E8")]),_:1},8,["onClick"]),n(p,{type:"primary",onClick:f.clearUpload},{default:u(()=>[K("\u6E05\u7A7A\u5DF2\u4E0A\u4F20")]),_:1},8,["onClick"]),n(p,{type:"danger",onClick:f.close},{default:u(()=>[K("\u5173\u95ED")]),_:1},8,["onClick"]),m("div",Yt,[n(h,{modelValue:a.albumName,"onUpdate:modelValue":t[3]||(t[3]=g=>a.albumName=g),placeholder:"\u9009\u62E9\u76F8\u518C"},{default:u(()=>[(w(!0),C(X,null,ae(a.albums,(g,V)=>(w(),U(_,{key:V,label:g,value:g},null,8,["label","value"]))),128)),m("div",Xt,[n(D,{modelValue:a.newAlbum,"onUpdate:modelValue":t[2]||(t[2]=g=>a.newAlbum=g),placeholder:"\u65B0\u5EFA\u76F8\u518C",type:"text",onKeyup:it(f.addAlbum,["enter"])},null,8,["modelValue","onKeyup"])])]),_:1},8,["modelValue"])]),m("div",qt,[Ie(n(j,{percentage:a.progress.percentage,status:a.progress.status},null,8,["percentage","status"]),[[ke,a.progress.show]])])]),n(M,{modelValue:a.dialogVisible,"onUpdate:modelValue":t[4]||(t[4]=g=>a.dialogVisible=g),width:"70%",top:"60px",style:{"background-color":"transparent"}},{default:u(()=>[m("div",Wt,[m("img",{src:a.dialogImageUrl},null,8,Kt)])]),_:1},8,["modelValue"])]),_:1},8,["modelValue"])])}const Jt=Ge(St,[["render",Zt],["__scopeId","data-v-abadd73b"]]);export{Jt as default};
