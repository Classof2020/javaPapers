/*!CK:1121380239!*//*1456170332,*/

if (self.CavalryLogger) { CavalryLogger.start_js(["hivrN"]); }

__d('HighContrastMode',['AccessibilityLogger','CSS','CurrentUser','DOM','Style','URI','emptyFunction'],function a(b,c,d,e,f,g,h,i,j,k,l,m,n){if(c.__markCompiled)c.__markCompiled();var o={init:function(p){var q=new m(window.location.href);if(q.getPath().indexOf('/intern/')===0)return;if(window.top!==window.self)return;var r=k.create('div');k.appendContent(document.body,r);r.style.cssText='border: 1px solid !important;'+'border-color: red green !important;'+'position: fixed;'+'height: 5px;'+'top: -999px;'+'background-image: url('+p.spacerImage+') !important;';var s=l.get(r,'background-image'),t=l.get(r,'border-top-color'),u=l.get(r,'border-right-color'),v=t==u&&s&&(s=='none'||s=='url(invalid-url:)');if(v){i.conditionClass(document.documentElement,'highContrast',v);if(j.getID())h.logHCM();}k.remove(r);o.init=n;}};f.exports=o;},null);