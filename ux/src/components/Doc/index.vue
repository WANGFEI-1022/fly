<template>
  <div>
    <svg-icon icon-class="question" @click="goto" />
  </div>
</template>

<script>
export default {
  name: 'Doc',
  data() {
    return {
      url: 'https://github.com/WFLJQ/fly/wiki/'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
