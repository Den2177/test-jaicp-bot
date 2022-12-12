require: slotfilling/slotFilling.sc
  module = sys.zb-common

require: patterns.sc
  module = sys.zb-common
theme: /

    state: newNode_1
        q!: $regex</start>
        a: {{$dialer.getPayload().name}}, добрый день! Вас приветствует центр дистанционного контроля состояния здоровья пациентов .
        a: --  - Подскажите,  --  -  Готовы ли вы сейчас сообщить информацию, - касательно  вашего состоянии здоровья? 
        state: 1
            q: да
            go!: /newNode_3
        state: 2    
            q: Нет
            go!: /
        
        
  
            
    state: newNode_3
        # q!: $regex</start>
        a: Регулярные шевелится у вас  плод?
        state: 1
            q: да
            q: конечно
            q: Все верно
            q: да есть
            q: ага
            q: угу 
            q: согласен
            q: согласие
            q: есть
            q: было
            q: было такое
            q: подтверждаю
            q: да да
            q: *Да
            q: Да*
            q: Шевелится
            q: есть есть
            q: конечно конечно
            q: было вроде
            q: вроде как есть
            q: *Есть*
            q: $yes
            q: $agree
            q: $agreeWeak
            intent: /Согласие
            
            go!: /newNode_3yes
        state: 2    
            q: Нет
            q: отрицаю
            q: не было
            q: неа
            q: отрицательно
            q: нет 
            q: не замечала
            q: не видела
            q: вроде нет
            q: нет вроде
            q: не согласна
            q: Нет нет
            q: *Нет*
            q: $no
            q: $disagree
            q: $disagreeWeak
            intent: /Отрицание
            go!: /newNode_3no
    
    state: newNode_3yes
        script: 
            $session.fetalMovements = "Да"
        go!: /newNode_4
        
    state: newNode_3no    
        script: 
            $session.fetalMovements = "Нет"
        go!: /newNode_4     
        
    state: newNode_4
        a: Присутствуют ли у вас боли в области печени?
        state: 1
            q: да
            q: да
            q: конечно
            q: Все верно
            q: да есть
            q: ага
            q: угу 
            q: согласен
            q: согласие
            q: есть
            q: было
            q: было такое
            q: подтверждаю
            q: да да
            q: *Да
            q: Да*
            q: Шевелится
            q: есть есть
            q: конечно конечно
            q: было вроде
            q: вроде как есть
            q: *Есть*
            q: $yes
            q: $agree
            q: $agreeWeak
            intent: /Согласие
            go!: /newNode_4yes
        state: 2    
            q: Нет
            q: Нет
            q: отрицаю
            q: не было
            q: неа
            q: отрицательно
            q: нет 
            q: не замечала
            q: не видела
            q: вроде нет
            q: нет вроде
            q: не согласна
            q: Нет нет
            q: *Нет*
            q: $no
            q: $disagree
            q: $disagreeWeak
            intent: /Отрицание
            go!: /newNode_4no
            
    state: newNode_4yes
        script: 
            $session.painLiver = "Да"
        go!: /newNode_5
        
    state: newNode_4no    
        script: 
            $session.painLiver = "Нет"
        go!: /newNode_5
    
    
    
    state: newNode_5
        a: Есть ли у вас чувство тошноты?
        state: 1
            q: да
            q: да
            q: конечно
            q: Все верно
            q: да есть
            q: ага
            q: угу 
            q: согласен
            q: согласие
            q: есть
            q: было
            q: было такое
            q: подтверждаю
            q: да да
            q: *Да
            q: Да*
            q: Шевелится
            q: есть есть
            q: конечно конечно
            q: было вроде
            q: вроде как есть
            q: *Есть*
            q: $yes
            q: $agree
            q: $agreeWeak
            intent: /Согласие
            go!: /newNode_5yes
        state: 2    
            q: Нет
            q: Нет
            q: отрицаю
            q: не было
            q: неа
            q: отрицательно
            q: нет 
            q: не замечала
            q: не видела
            q: вроде нет
            q: нет вроде
            q: не согласна
            q: Нет нет
            q: *Нет*
            q: $no
            q: $disagree
            q: $disagreeWeak
            intent: /Отрицание
            go!: /newNode_5no
            
    state: newNode_5yes
        script: 
            $session.nausea = "Да"
        go!: /newNode_6
        
    state: newNode_5no    
        script: 
            $session.nausea = "Нет"    
        go!: /newNode_6    
            
    state: newNode_6
        a: Есть ли у вас рвота?
        state: 1
            q: да
            q: да
            q: конечно
            q: Все верно
            q: да есть
            q: ага
            q: угу 
            q: согласен
            q: согласие
            q: есть
            q: было
            q: было такое
            q: подтверждаю
            q: да да
            q: *Да
            q: Да*
            q: Шевелится
            q: есть есть
            q: конечно конечно
            q: было вроде
            q: вроде как есть
            q: *Есть*
            q: $yes
            q: $agree
            q: $agreeWeak
            intent: /Согласие
            go!: /newNode_6yes    
        state: 2    
            q: Нет
            q: Нет
            q: отрицаю
            q: не было
            q: неа
            q: отрицательно
            q: нет 
            q: не замечала
            q: не видела
            q: вроде нет
            q: нет вроде
            q: не согласна
            q: Нет нет
            q: *Нет*
            q: $no
            q: $disagree
            q: $disagreeWeak
            intent: /Отрицание
            go!: /newNode_6no
            
    state: newNode_6yes       
        InputNumber:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = Скажите, сколько раз в день проявляется симптом рвота?
            varName = vomit
            failureMessage = ["Скажите, сколько раз в день проявляется симптом рвота?"]
            then = /newNode_8
            minValue = 1
            maxValue = 220
            html = Скажите, сколько раз в день проявляется симптом рвота?
            htmlEnabled = false
            failureMessageHtml = ["Скажите, сколько раз в день проявляется симптом рвота?"]        
            
    state: newNode_6no    
        script: 
            $session.vomit = 0 
        go!: /newNode_8    
    
    # state: newnode_7
    #     a: Есть ли у вас головные боли
    #     state: 1
    #         q: да
    #         go!: /newNode_7yes    
    #     state: 2    
    #         q: Нет
    #         go!: /newNode_7no
            
    state: newNode_7yes
        script: 
            $session.edema = "Да"
        go!: /newNode_8 
        
    state: newNode_7no    
        script: 
            $session.edema = "Нет" 
        go!: /newNode_8   
    state: newNode_8
        a: Есть ли у вас головные боли?
        state: 1
            q: да
            q: да
            q: конечно
            q: Все верно
            q: да есть
            q: ага
            q: угу 
            q: согласен
            q: согласие
            q: есть
            q: было
            q: было такое
            q: подтверждаю
            q: да да
            q: *Да
            q: Да*
            q: Шевелится
            q: есть есть
            q: конечно конечно
            q: было вроде
            q: вроде как есть
            q: *Есть*
            q: $yes
            q: $agree
            q: $agreeWeak
            intent: /Согласие
            go!: /newNode_8yes
        state: 2    
            q: Нет
            q: Нет
            q: отрицаю
            q: не было
            q: неа
            q: отрицательно
            q: нет 
            q: не замечала
            q: не видела
            q: вроде нет
            q: нет вроде
            q: не согласна
            q: Нет нет
            q: *Нет*
            q: $no
            q: $disagree
            q: $disagreeWeak
            intent: /Отрицание
            go!: /newNode_8no
            
    state: newNode_8yes
        script: 
            $session.headache = "Да"
        go!: /newNode_9
        
    state: newNode_8no    
        script: 
            $session.headache = "Нет"        
        go!: /newNode_9
        
        
    state: newNode_9
        a: Замечали ли вы Мелькание мушек перед глазами?
        state: 1
            q: да
            q: да
            q: конечно
            q: Все верно
            q: да есть
            q: ага
            q: угу 
            q: согласен
            q: согласие
            q: есть
            q: было
            q: было такое
            q: подтверждаю
            q: да да
            q: *Да
            q: Да*
            q: Шевелится
            q: есть есть
            q: конечно конечно
            q: было вроде
            q: вроде как есть
            q: *Есть*
            q: $yes
            q: $agree
            q: $agreeWeak
            intent: /Согласие
            go!: /newNode_9yes
            
        state: 2    
            q: Нет
            q: Нет
            q: отрицаю
            q: не было
            q: неа
            q: отрицательно
            q: нет 
            q: не замечала
            q: не видела
            q: вроде нет
            q: нет вроде
            q: не согласна
            q: Нет нет
            q: *Нет*
            q: $no
            q: $disagree
            q: $disagreeWeak
            intent: /Отрицание
            go!: /newNode_9no
            
    state: newNode_9yes
        script: 
            $session.fliesFlickeringEyes = "Да"
        go!: /newNode_10
        
    state: newNode_9no    
        script: 
            $session.fliesFlickeringEyes = "Нет"       
        go!: /newNode_10
        
        
    state: newNode_10
        a: Присутствует ли у вас онемение Рук или ног?
        state: 1
            q: да
            q: да
            q: конечно
            q: Все верно
            q: да есть
            q: ага
            q: угу 
            q: согласен
            q: согласие
            q: есть
            q: было
            q: было такое
            q: подтверждаю
            q: да да
            q: *Да
            q: Да*
            q: Шевелится
            q: есть есть
            q: конечно конечно
            q: было вроде
            q: вроде как есть
            q: *Есть*
            q: $yes
            q: $agree
            q: $agreeWeak
            intent: /Согласие
            go!: /newNode_10yes
            
        state: 2    
            q: Нет
            q: Нет
            q: отрицаю
            q: не было
            q: неа
            q: отрицательно
            q: нет 
            q: не замечала
            q: не видела
            q: вроде нет
            q: нет вроде
            q: не согласна
            q: Нет нет
            q: *Нет*
            q: $no
            q: $disagree
            q: $disagreeWeak
            intent: /Отрицание
            go!: /newNode_10no
            
            
    state: newNode_10yes
        script: 
            $session.limbNumbness = "Да"
        go!: /newNode_11
        
    state: newNode_10no    
        script: 
            $session.limbNumbness = "Нет"  
        go!: /newNode_11 
         
       
    
    state: newNode_11 
        a: Имеются ли у вас отеки голеней?
        state: 1
            q: да
            q: да
            q: конечно
            q: Все верно
            q: да есть
            q: ага
            q: угу 
            q: согласен
            q: согласие
            q: есть
            q: было
            q: было такое
            q: подтверждаю
            q: да да
            q: *Да
            q: Да*
            q: Шевелится
            q: есть есть
            q: конечно конечно
            q: было вроде
            q: вроде как есть
            q: *Есть*
            q: $yes
            q: $agree
            q: $agreeWeak
            intent: /Согласие
            go!: /newNode_11yes
            
        state: 2    
            q: Нет
            q: Нет
            q: отрицаю
            q: не было
            q: неа
            q: отрицательно
            q: нет 
            q: не замечала
            q: не видела
            q: вроде нет
            q: нет вроде
            q: не согласна
            q: Нет нет
            q: *Нет*
            q: $no
            q: $disagree
            q: $disagreeWeak
            intent: /Отрицание
            go!: /newNode_11no
            
            
    state: newNode_11yes
        script: 
            $session.swellingOfTheLegs = "Да"
        go!: /newNode_12
        
    state: newNode_11no    
        script: 
            $session.swellingOfTheLegs = "Нет"
        go!: /newNode_12 
        
    state: newNode_12
        a: Есть ли у  вас отеки стоп?
        state: 1
            q: да
            q: да
            q: конечно
            q: Все верно
            q: да есть
            q: ага
            q: угу 
            q: согласен
            q: согласие
            q: есть
            q: было
            q: было такое
            q: подтверждаю
            q: да да
            q: *Да
            q: Да*
            q: Шевелится
            q: есть есть
            q: конечно конечно
            q: было вроде
            q: вроде как есть
            q: *Есть*
            q: $yes
            q: $agree
            q: $agreeWeak
            intent: /Согласие
            go!: /newNode_12yes
            
        state: 2    
            q: Нет
            q: Нет
            q: отрицаю
            q: не было
            q: неа
            q: отрицательно
            q: нет 
            q: не замечала
            q: не видела
            q: вроде нет
            q: нет вроде
            q: не согласна
            q: Нет нет
            q: *Нет*
            q: $no
            q: $disagree
            q: $disagreeWeak
            intent: /Отрицание
            go!: /newNode_12no
            
            
    state: newNode_12yes
        script: 
            $session.footSwelling = "Да"
        go!: /newNode_13    
            
    state: newNode_12no   
        script: 
            $session.footSwelling = "Нет"   
        go!: /newNode_13    
            
    state: newNode_13
        a: Присутствуют ли у вас отеки рук? 
        state: 1
            q: да
            q: да
            q: конечно
            q: Все верно
            q: да есть
            q: ага
            q: угу 
            q: согласен
            q: согласие
            q: есть
            q: было
            q: было такое
            q: подтверждаю
            q: да да
            q: *Да
            q: Да*
            q: Шевелится
            q: есть есть
            q: конечно конечно
            q: было вроде
            q: вроде как есть
            q: *Есть*
            q: $yes
            q: $agree
            q: $agreeWeak
            intent: /Согласие
            go!: /newNode_13yes
            
            
        state: 2    
            q: Нет
            q: Нет
            q: отрицаю
            q: не было
            q: неа
            q: отрицательно
            q: нет 
            q: не замечала
            q: не видела
            q: вроде нет
            q: нет вроде
            q: не согласна
            q: Нет нет
            q: *Нет*
            q: $no
            q: $disagree
            q: $disagreeWeak
            intent: /Отрицание
            go!: /newNode_13no
            
            
    state: newNode_13yes
        script: 
            $session.swellingOfTheHands = "Да";
        go!: /newNode_14
        
            
    state: newNode_13no         
        script: 
            $session.footSwelling = "Нет";
        go!: /newNode_14
        
            
    state: newNode_14
        a: Беспокоет ли вас отечность лица?  
        state: 1
            q: да
            q: да
            q: конечно
            q: Все верно
            q: да есть
            q: ага
            q: угу 
            q: согласен
            q: согласие
            q: есть
            q: было
            q: было такое
            q: подтверждаю
            q: да да
            q: *Да
            q: Да*
            q: Шевелится
            q: есть есть
            q: конечно конечно
            q: было вроде
            q: вроде как есть
            q: *Есть*
            q: $yes
            q: $agree
            q: $agreeWeak
            intent: /Согласие
            go!: /newNode_14yes
            
        state: 2    
            q: Нет
            q: Нет
            q: отрицаю
            q: не было
            q: неа
            q: отрицательно
            q: нет 
            q: не замечала
            q: не видела
            q: вроде нет
            q: нет вроде
            q: не согласна
            q: Нет нет
            q: *Нет*
            q: $no
            q: $disagree
            q: $disagreeWeak
            intent: /Отрицание
            go!: /newNode_14no
    
    
    state: newNode_14yes
        script: 
            $session.puffinessOfTheFace = "Да";
        go!: /preparets
            
    state: newNode_14no         
        script: 
            $session.puffinessOfTheFace = "Нет";    
        go!: /preparets
    
    
    state: preparets 
        a: Назовите препараты, которые вы принимаете?
        InputText:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = 
            varName = preparets
            html = 
            htmlEnabled = false
            then = /newNode_15  
            
    state: newNode_15     
        InputNumber:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = Назовите верхнюю цифру артериального давления?
            varName = artDavlLeft
            failureMessage = ["Назовите верхнюю цифру артериального давления?"]
            then = /newNode_16
            minValue = 1
            maxValue = 220
            html = Назовите верхнюю цифру артериального давления?
            htmlEnabled = false
            failureMessageHtml = ["Назовите верхнюю цифру артериального давления?"]        
    
    state: newNode_16     
        InputNumber:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = Назовите нижнюю цифру артериального давления?
            varName = artDavlRight
            failureMessage = ["Назовите нижнюю цифру артериального давления?"]
            then = /zapros
            minValue = 1
            maxValue = 220
            html = Назовите нижнюю цифру артериального давления?
            htmlEnabled = false
            failureMessageHtml = ["Назовите нижнюю цифру артериального давления?"]        
            
    state: zapros
        HttpRequest:
            url = https://api.dev.doctis.app/api/remote-monitoring/calling_result
            method = POST
            dataType = 
            body = {"name": "{{$dialer.getPayload().name}}","38c9cef1-c4a3-4ff0-9cd8-5efebe78ed43":"{{$session.fetalMovements}}","f2b2f172-98ca-459e-9ff8-6064c3556481":"{{$session.painLiver}}","ffdb81b3-a076-4482-ba8a-aa0f3eac3da9":"{{$session.nausea}}","d69380e3-abfd-42a0-bc7e-612689bf8af5":"{{$session.vomit}}","e9a5240d-5adf-4fcf-91cb-fb504d2fac4c":"{{$session.headache}}","114d73fc-17bd-4732-8025-49fa65049f69":"{{$session.fliesFlickeringEyes}}","040328cf-3667-4f3e-b4c4-476cb184e926":"{{$session.limbNumbness}}","c114c7c7-6d1e-4f2e-8405-9232233eb914":"{{$session.preparets}}","60d5700d-3ea8-431d-af30-127e7f587f6c":"{{$session.footSwelling}}","60685842-7ac2-4e16-af3f-d18aafa8a74b":"{{$session.swellingOfTheLegs}}","98b7062a-9014-4724-99a3-9bd6c8742314":"{{$session.swellingOfTheHands}}","3bb614b4-873c-4dbd-883e-4e5fce5426cc":"{{$session.puffinessOfTheFace}}","fa90b60d-c751-4124-a714-e57466e8c694":"{{$session.artDavlLeft}}","e78c3c0b-6996-4130-bc3d-be6ace32ff53":"{{$session.artDavlRight}}","patient_id": "{{$dialer.getPayload().patient_id}}", "call_id": "{{$dialer.getPayload().call_id}}"}
            headers = {"apiKey": "a9db7c01-e309-4a61-b04d-faffdfd020c0"}
            okState = /newNode_155
            errorState = 
            timeout = 0
            vars =   
            
    state: zapros1
        HttpRequest:
            url = https://api.dev.doctis.app/api/remote-monitoring/change_owner_type
            method = POST
            dataType = 
            # headers = [{"ApiKey": "a9db7c01-e309-4a61-b04d-faffdfd020c0"}]
            body = {"callId":"{{$dialer.getPayload().call_id}}","ownerType": "{{0}}"}
            okState = /newNode_155
            errorState = 
            timeout = 0
            vars =         
    
    state: newNode_155
        a: Спасибо за информацию, хорошего вам дня! || tts = "Спасибо за информацию, хорошего вам дня!", ttsEnabled = true
        # Transition /newNode_156
        go!: /newNode_153        
        
    state: newNode_153
        EndSession:
    