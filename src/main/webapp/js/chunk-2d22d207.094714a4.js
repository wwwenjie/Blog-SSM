(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d22d207"],{f5bd:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-container",[a("v-row",[a("v-col",{attrs:{cols:"12"}},[e._t("default")],2),e._l(e.articles,(function(t,n){return a("feed-card",{key:t.articleId,attrs:{size:e.layout[n],value:t}})}))],2),a("v-row",{attrs:{align:"center"}},[a("v-col",{attrs:{cols:"3"}},[1!==e.page?a("base-btn",{staticClass:"ml-0",attrs:{square:"",title:"Previous page"},on:{click:function(t){e.page--}}},[a("v-icon",[e._v("mdi-chevron-left")])],1):e._e()],1),a("v-col",{staticClass:"text-center subheading",attrs:{cols:"6"}},[e._v(" PAGE "+e._s(e.page)+" OF "+e._s(e.pages)+" ")]),a("v-col",{staticClass:"text-right",attrs:{cols:"3"}},[e.pages>1&&e.page<e.pages?a("base-btn",{staticClass:"mr-0",attrs:{square:"",title:"Next page"},on:{click:function(t){e.page++}}},[a("v-icon",[e._v("mdi-chevron-right")])],1):e._e()],1)],1)],1)},r=[],c=(a("d3b7"),a("96cf"),a("1da1")),s=a("2423"),i={name:"Feed",components:{FeedCard:function(){return a.e("chunk-4cb0f8a8").then(a.bind(null,"eb3a"))}},data:function(){return{articles:void 0,layout:[1,2,2,2,2,3,3,3,3,3,3],page:1,pages:1}},watch:{page:function(){var e=this;return Object(c["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return window.scrollTo(0,0),t.next=3,Object(s["e"])(e.page,8);case 3:e.articles=t.sent;case 4:case"end":return t.stop()}}),t)})))()}},mounted:function(){var e=this;return Object(c["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,Object(s["e"])(0,8);case 2:return e.articles=t.sent,t.t0=Math,t.next=6,Object(s["f"])();case 6:t.t1=t.sent,t.t2=t.t1/8,e.pages=t.t0.ceil.call(t.t0,t.t2);case 9:case"end":return t.stop()}}),t)})))()}},o=i,l=a("2877"),u=a("6544"),d=a.n(u),p=a("62ad"),f=a("a523"),g=a("132d"),v=a("0fd9"),b=Object(l["a"])(o,n,r,!1,null,null,null);t["default"]=b.exports;d()(b,{VCol:p["a"],VContainer:f["a"],VIcon:g["a"],VRow:v["a"]})}}]);
//# sourceMappingURL=chunk-2d22d207.094714a4.js.map